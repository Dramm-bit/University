package first.api.flightcatalog.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Flight {
    private long id;
    private String departureDate;
    private String departureAirportCode;
    private String departureAirportName;
    private String departureCity;
    private String departureLocale;
    private String arrivalDate;
    private String arrivalAirportCode;
    private String arrivalAirportName;
    private String arrivalCity;
    private String arrivalLocale;
    private int ticketPrice;
    private String ticketCurrency;
    private int flightNumber;
    private int seatCapacity;

    @Id
    public long getId() {
        return id;
    }

    //que hace esta wea xd
    public Flight updateWith(Flight vuelo) {
        return new Flight(
                this.id,
                vuelo.departureDate,
                vuelo.departureAirportCode,
                vuelo.departureAirportName,
                vuelo.departureCity,
                vuelo.departureLocale,
                vuelo.arrivalDate,
                vuelo.arrivalAirportCode,
                vuelo.arrivalAirportName,
                vuelo.arrivalCity,
                vuelo.arrivalLocale,
                vuelo.ticketPrice,
                vuelo.ticketCurrency,
                vuelo.flightNumber,
                vuelo.seatCapacity

        );
    }

   
}
