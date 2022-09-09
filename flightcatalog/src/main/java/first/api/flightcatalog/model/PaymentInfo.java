package first.api.flightcatalog.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "payment_info")
@Data

public class PaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "payment-method")
    private String paymentMethod;

    @Column(name = "card_number")
    private long cardNumber;

    @Column(name = "postal_code")
    private int postalCode;

    private String country;

    private String state;




    @OneToOne(cascade=CascadeType.ALL,mappedBy = "paymentInfo")
    private User user;

}
