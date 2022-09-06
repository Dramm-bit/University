package first.api.flightcatalog.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Table(name = "users")

public class User {
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinTable(
        name="RESERVED",
        joinColumns =@JoinColumn(name = "USER_ID", referencedColumnName ="id"),
        inverseJoinColumns =@JoinColumn(name="BOOKING_ID", referencedColumnName="id")
    )
    private List<Booking> reservedFlights = new ArrayList<>();
     public void addReserve(Booking reserve){
        this.reservedFlights.add(reserve);
     }

}
