package first.api.flightcatalog.model;



import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(mappedBy = "id")
    @JoinColumn(name = "id_payment")
    private PaymentInfo paymentinfo;
    
    @OneToMany(mappedBy = "id")
    private Set<Booking> bookings;
}