package first.api.flightcatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import first.api.flightcatalog.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    
}
