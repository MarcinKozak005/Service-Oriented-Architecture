package workingOne;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@Getter
@Setter
@SQLDelete(sql ="UPDATE b SET deleted = true WHERE id = ?")
@Loader(namedQuery = "findByIdB")
@NamedQuery(name = "findByIdB", query ="SELECT x FROM B x WHERE x.id = ?1 AND x.deleted = false")
@Where(clause = "deleted = false")
public class B { // Loan
    @Id
    @GeneratedValue
    int id;

    String b_name;

    @ManyToOne
    A a;

    boolean deleted;
}
