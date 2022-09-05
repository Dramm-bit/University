package first.api.flightcatalog.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor

public class Booking {
    private Integer id;
    private BookingStatus status;
    private Flight outbound;
    private String paymentToken;
    private Boolean checkedIn;
    private User customer;
    private String createdAt;
    private String bookingReference;

    @Id
    public long getId() {
        return id;
    }

    public Booking updateWith(Booking newData) {
        return new Booking(
            this.id,
            newData.status,
            newData.outbound,
            newData.paymentToken,
            newData.checkedIn,
            newData.customer,
            newData.createdAt,
            newData.bookingReference
        );

    }

}
