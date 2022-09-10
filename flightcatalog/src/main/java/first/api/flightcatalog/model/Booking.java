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


    @Column(name = "payment_token")
    private String paymentToken;

    @Column(name = "checked_in")
    private Boolean checkedIn;


    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "booking_reference")
    private String bookingReference;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private Flight outboundflight;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_customer", referencedColumnName ="id") // Como en la linea de abajo indicamos con que tabla se relaciona el busca por
                                  // defecto el id de dicha tabla
    private User customer;
}

