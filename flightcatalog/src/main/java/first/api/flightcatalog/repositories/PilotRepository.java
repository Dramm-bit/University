package first.api.flightcatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import first.api.flightcatalog.model.Pilot;

public interface PilotRepository extends JpaRepository<Pilot, Long> {
    
}
