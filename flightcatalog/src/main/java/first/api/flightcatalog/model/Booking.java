package first.api.flightcatalog.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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


    @Column(name = "Payment_Token")
    private String paymentToken;

    @Column(name = "Checked_In")
    private Boolean checkedIn;

    

    @Column(name = "Created_At")
    private String createdAt;

    @Column(name = "Booking_Reference")
    private String bookingReference;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_outbondflight", nullable = false)
    private Flight outboundflight;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_customer") // Como en la linea de abajo indicamos con que tabla se relaciona el busca por
                                  // defecto el id de dicha tabla
    private User custumer;
}

