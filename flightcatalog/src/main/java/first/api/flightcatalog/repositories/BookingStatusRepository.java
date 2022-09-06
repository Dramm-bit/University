package first.api.flightcatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import first.api.flightcatalog.model.BookingStatus;

public interface BookingStatusRepository extends JpaRepository<BookingStatus, Long> {
    
}
