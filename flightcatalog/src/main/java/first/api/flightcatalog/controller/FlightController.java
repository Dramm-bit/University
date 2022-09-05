package first.api.flightcatalog.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.Servlet;
import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import first.api.flightcatalog.model.Flight;
import first.api.flightcatalog.services.FlightService;

@RestController
@RequestMapping("api/catalog/")
public class FlightController {
    
    private final FlightService service;

    public FlightController(FlightService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Flight>> findFlights(
        @RequestParam(defaultValue = "") String departureAirportCode,
        @RequestParam(defaultValue = "") String arrivalAirportCode
    ){
       
        List<Flight> flightsList = service.findAll();
        List<Flight> flights = new ArrayList<>();
      
        flightsList.forEach( 
            (flight) -> {

            Boolean condition = true;
            if(!departureAirportCode.isBlank()) {
                condition = condition && flight.getDepartureAirportCode().equals(departureAirportCode);
            }
            if(!arrivalAirportCode.isBlank()){
                condition = condition && flight.getArrivalAirportName().equals(arrivalAirportCode);
            }

            if(
                condition
            )
                flights.add(flight); 
            }  
        );
        return ResponseEntity.ok().body(flights);


    }
    
    @PostMapping
    public ResponseEntity<Flight> create(@Valid @RequestBody Flight flight){
        Flight created = service.create(flight);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(created.getId())
            .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> update(
        @PathVariable("id") Long id,
        @Valid @RequestBody Flight updatedItem
    ){
        Optional<Flight> updated = service.update(id, updatedItem);

        return updated
            .map(value -> ResponseEntity.ok().body(value))
            .orElseGet(()-> {
                Flight created = service.create(updatedItem);
                URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(created.getId())
                        .toUri();
                return ResponseEntity.created(location).body(created);
            });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Flight> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
