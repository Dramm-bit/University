package first.api.flightcatalog.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment_info")
@Data
@NoArgsConstructor

public class PaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "card_number")
    private Integer cardNumber;

    @Column(name = "postal_code")
    private int postalCode;

    private String country;

    private String state;


    @OneToOne(mappedBy ="paymentInfo")
    private User user;

}
