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

    /**
     * @param departureAirportCode
     * @param arrivalAirportCode
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Flight>> findFlights(
        @RequestParam(defaultValue = "") Optional<String> departureAirportCode,
        @RequestParam(defaultValue = "") Optional<String> arrivalAirportCode
    ){
        List<Flight> flights = new ArrayList<Flight>();
        if(departureAirportCode.isEmpty() && arrivalAirportCode.isEmpty()){
            flights = service.findAll();
            return ResponseEntity.ok().body(flights);
        }else if(!departureAirportCode.isEmpty() && arrivalAirportCode.isEmpty()){
            List<Flight> flightsList = service.findAll();
            flightsList.forEach( 
              (flight) -> extracted(departureAirportCode, flights, flight)  
            );
        }else if(departureAirportCode.isEmpty() && !arrivalAirportCode.isEmpty()){
            List<Flight> flightsList = service.findAll();
            flightsList.forEach( 
              (flight) -> extracted(arrivalAirportCode, flights, flight);  
            );
        }
        return ResponseEntity.ok().body(flights);
    }

    private void extracted(Optional<String> code, List<Flight> flights, Flight flight) {
        if(flight.getDepartureAirportCode().toString().equals(code))
            flights.add(flight);
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
