package first.api.flightcatalog.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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

    private Iterable defaultFlights() {
        return List.of(
                new Flight(1, "23-04-2022", "123", "askpk12po43",
                        "Moteria", "fk34k34k43", "23-04-2022", "2394",
                        "name1", "monteria", "no me acuerdo xd", 120000,
                        "COP", 101, 50),
                new Flight(2, "23-04-2022", "123", "askpk12po43", "Cali",
                        "o4334500", "24-04-2022", "2394", "name2",
                        "Bogota", "no me acuerdo xd", 150000, "COP", 102, 50),
                new Flight(3, "25-04-2022", "234ij4o", "askpk12po43", "bucaramanga",
                        "wiopejkrio34jr", "25-04-2022", "444", "name3",
                        "Medellin", "no me acuerdo xd", 100000, "COP", 103, 50));
    }

    public List<Flight> findAll() {
        List<Flight> listFlights = new ArrayList<>();
        Iterable<Flight> vuelos = repository.findAll();

        vuelos.forEach(listFlights::add);
        return listFlights;
    }

    public List<Flight> search4param(String dac, String aac, String dd) {
        List<Flight> flightsList = findAll();
        List<Flight> flights = new ArrayList<>();

        flightsList.forEach(
                (flight) -> {

                    Boolean condition = true;
                    if (!dac.isBlank()) {
                        condition = condition && flight.getDepartureAirportCode().equals(dac);
                    }
                    if (!aac.isBlank()) {
                        condition = condition && flight.getArrivalAirportName().equals(aac);
                        

                    }
                    if (!dd.isBlank()) {
                        condition = condition && flight.getDepartureDate().equals(dd);
                    }

                    if (condition)
                        flights.add(flight);
                });

        return flights;
    }

    public List<Flight> findbydate (String date) {
        List<Flight> copyFlights = findAll();
        
        List<Flight> filteredFlights = new ArrayList<>();

        copyFlights.stream().filter(f->f.getDepartureDate().equals(date)).forEach(filteredFlights::add); 
        
    
        return filteredFlights; 

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
                vuelo.getSeatCapacity());
        return repository.save(nuevoVuelo);
    }

    public Optional<Flight> update(Long id, Flight newFlight) {
        return repository.findById(id).map(
                oldItem -> {
                    Flight updated = oldItem.updateWith(newFlight);
                    return repository.save(updated);
                });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
