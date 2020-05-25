package DateTest;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
@Getter
@Setter
public class Date {
    @Id
    @GeneratedValue
    private int date_id;

}
