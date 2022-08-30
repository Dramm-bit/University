package first.api.flightcatalog.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.map.repository.config.EnableMapRepositories;
import org.springframework.stereotype.Service;

import first.api.flightcatalog.model.Flight;
import first.api.flightcatalog.repositories.LocalFlightsRepository;

@Service
@EnableMapRepositories("first.api.flightcatalog.repositories")
public class FlightService {
    private final LocalFlightsRepository repository;

    public FlightService(LocalFlightsRepository repository) {
        this.repository = repository;
        this.repository.saveAll(defaultFlights());
    }

    private Iterable defaultFlights(){
        return List.of(   
            new Flight(1, "23-04-2022", "234ij4o","askpk12po43", 
                        "Moteria","fk34k34k43","23-04-2022", "2394834f", 
                        "ojeopgkpork", "monteria","no me acuerdo xd", 120000,
                        "COP", 101,50),
            new Flight(2, "24-04-2022", "234ij4o","askpk12po43", "Cali",
                        "o4334500","24-04-2022", "2394834f", "ojeopgkpork", 
                        "Bogota","no me acuerdo xd", 150000,"COP", 102,50 ),
            new Flight(3, "25-04-2022", "234ij4o","askpk12po43", "bucaramanga",
                        "wiopejkrio34jr","25-04-2022", "2394834f", "ojeopgkpork", 
                        "Medellin","no me acuerdo xd", 100000,"COP", 103,50 )
        );
    }

    public List<Flight> findAll() {
        List<Flight> listFlights = new ArrayList<>();
        Iterable<Flight> vuelos = repository.findAll();
        vuelos.forEach(listFlights::add);
        return listFlights;
    }

    public Optional<Flight> find(Long id) {
        return repository.findById(id);
    }

    public Flight create(Flight vuelo) {
        Flight nuevoVuelo = new Flight(
                new Date().getTime(),
                vuelo.getDepartureDate(),
                vuelo.getDepartureAirportCode(),
                vuelo.getDepartureAirportName(),
                vuelo.getDepartureCity(),
                vuelo.getDepartureLocale(),
                vuelo.getArrivalDate(),
                vuelo.getArrivalAirportCode(),
                vuelo.getArrivalAirportName(),
                vuelo.getArrivalCity(),
                vuelo.getArrivalLocale(),
                vuelo.getTicketPrice(),
                vuelo.getTicketCurrency(),
                vuelo.getFlightNumber(),
                vuelo.getSeatCapacity()
        );
        return repository.save(nuevoVuelo);
    }
}
