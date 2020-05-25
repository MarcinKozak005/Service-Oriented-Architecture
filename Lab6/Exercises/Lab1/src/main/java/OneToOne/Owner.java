package OneToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
//@Table
@NamedQuery(name = "getAllOwnersNamesWithDogs",
query = "SELECT o.name, d.dogName  FROM  Owner o, Dog d")
//@NamedQueries()
public class Owner {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToOne
    @JoinColumn(name = "dogid")
    private Dog dog;



}
