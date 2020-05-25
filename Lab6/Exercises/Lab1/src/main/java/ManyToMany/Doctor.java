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
public class Doctor {
    @Id
    @GeneratedValue
    private int doctor_id;

    @ManyToMany
    private List<Patient> cures;
}
