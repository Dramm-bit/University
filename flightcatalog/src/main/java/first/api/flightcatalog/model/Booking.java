package first.api.flightcatalog.model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data

@Table(name = "bookings")

public class Booking {

    @Id
    @Column(name = "ID_BOOKING")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CUSTOMER")
    private User customer;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;


    @ManyToOne
    @JoinColumn(name = "ID_FLIGHT")
    private Flight outboundflight;

@ManyToMany(mappedBy="ID_USER")
@JoinTable(
    name = "RESERVED",
    joinColumns = @JoinColumn(name = "BOOKING_ID", referencedColumnName = "ID_BOOKING"),
    inverseJoinColumns = @JoinColumn(name = "USER_ID", referencedColumnName ="ID_USER")
)
 private List<Booking> reserve = new ArrayList<>();
 
 public void addReserved (Booking _booking_){
    this.reserve.add(_booking_);
 }


}
