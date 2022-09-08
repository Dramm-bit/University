package first.api.flightcatalog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "paymentinfo's")
@Data

public class PaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    



    @OneToOne(mappedBy = "id")
    private User user;

}
