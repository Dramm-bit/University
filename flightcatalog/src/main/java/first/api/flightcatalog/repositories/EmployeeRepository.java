package first.api.flightcatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import first.api.flightcatalog.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
