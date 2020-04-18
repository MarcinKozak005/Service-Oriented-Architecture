import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_table")
public class Student {
    private int id;
    private String name;
    private String surname;
    private Date dateOfAddition;

    public Student(){super();}

    public Student(String name, String surname, Date dateOfAddition) {
        this.name = name;
        this.surname = surname;
        this.dateOfAddition = dateOfAddition;
    }

    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname", nullable = false)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    public Date getDateOfAddition() {
        return dateOfAddition;
    }

    public void setDateOfAddition(Date date) {
        this.dateOfAddition = date;
    }
}
