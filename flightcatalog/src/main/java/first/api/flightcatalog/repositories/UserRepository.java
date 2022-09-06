package first.api.flightcatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import first.api.flightcatalog.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
