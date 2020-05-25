package SoftDelete;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter
@Setter
@SQLDelete(sql ="UPDATE c SET deleted = true WHERE id = ?")
@Loader(namedQuery = "findByIdC")
@NamedQuery(name = "findByIdC", query ="SELECT x FROM C x WHERE x.id = ?1 AND x.deleted = false")
@Where(clause = "deleted = false")
public class C {
    @Id
    @GeneratedValue
    int id;

    String c_name;

    @ManyToOne
    B b;

    boolean deleted=false;
}
