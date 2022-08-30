package first.api.flightcatalog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import first.api.flightcatalog.model.Flight;


@Repository
public interface LocalFlightsRepository extends CrudRepository<Flight, Long>{
    
}
