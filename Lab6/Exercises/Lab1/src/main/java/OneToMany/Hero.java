package OneToMany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Hero {

    @Id
    @GeneratedValue
    private int heroId;

    private String heroName;

    @OneToMany(mappedBy = "owner")
//    @JoinTable(name = "HERO_WEAPON",
//    joinColumns = @JoinColumn(name = "HERO_ID"),
//    inverseJoinColumns = @JoinColumn(name = "WEAPON_ID"))
    private List<Weapon> weapons;
}
