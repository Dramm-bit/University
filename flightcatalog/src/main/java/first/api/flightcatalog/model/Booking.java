package first.api.flightcatalog.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Builder

@Table(name = "bookings")

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;




    @Enumerated(EnumType.STRING)
    private BookingStatus status;



    @ManyToMany(mappedBy = "bookings")
    private Set<User> users;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

}
