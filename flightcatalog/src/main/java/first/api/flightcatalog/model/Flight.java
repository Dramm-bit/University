package first.api.flightcatalog.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "flights")
@Data



public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;   

    @OneToMany(mappedBy = "id")
    private Set<Booking> reserved;

    @ManyToMany
    @JoinTable(
        name = "pilot_flights",
        joinColumns = @JoinColumns(name = "id_pilot", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_flight", referencedColumnName="id")
    )
    
   private List<Pilot> pilots = new ArrayList<>(); // no c pa que es esto :V

   public void addPilot(Pilot pilot){
    this.pilots.add(pilot);
   }

}
