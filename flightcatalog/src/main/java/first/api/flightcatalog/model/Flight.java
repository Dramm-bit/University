package first.api.flightcatalog.model;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Flight {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;





    @OneToMany(mappedBy = "flight")
    private Set<Booking> bookings;
}
