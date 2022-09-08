package first.api.flightcatalog.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "bookings")
@Data

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @ManyToOne()
    @JoinColumn(name="id_flight")
    private Flight flight;

    @ManyToOne()
    @JoinColumn(name="id_user")//Como en la linea de abajo indicamos con que tabla se relaciona el busca por defecto el id de dicha tabla
    private User user;
}
