package first.api.flightcatalog.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
@RequestMapping("api/catalog")
public class FlightController {

    private final FlightService serviceFlightService;

    public FlightController(FlightService serviceFlightService) {
        this.serviceFlightService = serviceFlightService;
    }

    @GetMapping("/find")
    public ResponseEntity<List<Flight>> findAll() {
        List<Flight> items = serviceFlightService.findAll();
        return ResponseEntity.ok().body(items);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Flight>> findFlights4Param(
            @RequestParam(defaultValue = "") String departureAirportCode,
            @RequestParam(defaultValue = "") String arrivalAirportName,
            @RequestParam(defaultValue = "") String departureDate) {
        List<Flight> findedFlights = serviceFlightService.search4param(departureAirportCode, arrivalAirportName,
                departureDate);

        return ResponseEntity.ok().body(findedFlights);

    }

    @PostMapping("/add")
    public ResponseEntity<Flight> create(@Valid @RequestBody Flight flight) {
        Flight created = serviceFlightService.create(flight);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> update(
            @PathVariable("id") Long id,
            @Valid @RequestBody Flight updatedItem) {
        Optional<Flight> updated = serviceFlightService.update(id, updatedItem);

        return updated
                .map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> {
                    Flight created = serviceFlightService.create(updatedItem);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(created.getId())
                            .toUri();
                    return ResponseEntity.created(location).body(created);
                });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Flight> delete(@PathVariable("id") Long id) {
        serviceFlightService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
