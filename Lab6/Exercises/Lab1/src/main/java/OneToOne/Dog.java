package OneToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Dog {
    @Id
    @GeneratedValue
    private int dogId;

    private String dogName;

    @OneToOne(mappedBy = "dog")
    private Owner myOwner;
}
