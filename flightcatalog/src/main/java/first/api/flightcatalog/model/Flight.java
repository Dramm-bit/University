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

    @Column(name = "Departure_Date")
    private String departureDate;

    @Column(name = "Departure_Airport_Code")
    private String departureAirportCode;

    @Column(name = "Departure_Airport_Name")
    private String departureAirportName;

    @Column(name = "Departure_City")
    private String departureCity;

    @Column(name = "Departure_Locale")
    private String departureLocale;

    @Column(name = "Arrival_Date")
    private String arrivalDate;

    @Column(name = "Arrival_Airport_Code")
    private String arrivalAirportCode;
 
    @Column(name = "Arrival_Airport_Name")
    private String arrivalAirportName;

    @Column(name = "Arrival_City")
    private String arrivalCity;

    @Column(name = "Arrival_Locale")
    private String arrivalLocale;

    @Column(name = "Ticket_Price")
    private int ticketPrice;

    @Column(name = "Ticket_Currency")
    private String ticketCurrency;

    @Column(name = "Flight_Number")
    private int flightNumber;

    @Column(name = "Set_Capacity")
    private int seatCapacity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "outboundflight")
    private Set<Booking> booking;
    
    @ManyToMany
    @JoinTable(
        name = "employees_flights",
        joinColumns = @JoinColumn(name = "id_employee"),
        inverseJoinColumns = @JoinColumn(name = "id_flight")
    )
    private List<Employee> employees = new ArrayList<>(); // no c pa que es esto :V

    public void addPilot(Employee employee) {
        this.employees.add(employee);
    }

   



}
