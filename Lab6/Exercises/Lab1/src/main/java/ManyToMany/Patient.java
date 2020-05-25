package ManyToMany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue
    private int patient_id;

    @ManyToMany(mappedBy = "cures")
    private List<Doctor> cured_by;
}
