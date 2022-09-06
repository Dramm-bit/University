package first.api.flightcatalog.repositories;

import org.springframework.data.repository.CrudRepository;

import first.api.flightcatalog.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long> {
    
}
