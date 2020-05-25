package OneToMany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Weapon {
    @Id
    @GeneratedValue
    private int weaponId;

    private String weaponName;

    @ManyToOne
//    @JoinColumn(name = "myStrangeName")
    private Hero owner;
}
