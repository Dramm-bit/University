package first.api.flightcatalog.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import lombok.Data;

@Entity
@Table(name = "flights")
@Data



public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;   

    
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "flights")
    private Set<Booking> bookings;

    @ManyToMany
    @JoinTable(
        name = "employee_flights",
        joinColumns = @JoinColumn(name = "id_employee"),
        inverseJoinColumns = @JoinColumn(name = "id_flight")
    )
    
   private List<Employee> employees = new ArrayList<>(); // no c pa que es esto :V

   public void addPilot(Employee employee){
    this.employees.add(employee);
   }

}
