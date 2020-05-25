package InheritanceMapping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "discriminatorType")
@DiscriminatorValue("bookClass")
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String author;
}
