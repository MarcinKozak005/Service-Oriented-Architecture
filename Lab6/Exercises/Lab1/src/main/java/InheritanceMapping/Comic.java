package InheritanceMapping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@DiscriminatorValue("comic")
public class Comic extends Book{
    private String illustrator;
}
