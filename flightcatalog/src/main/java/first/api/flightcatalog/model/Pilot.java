package first.api.flightcatalog.model;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name = "pilots")
@Data


public class Pilot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany
    private List<Flight> flights;
    
}
