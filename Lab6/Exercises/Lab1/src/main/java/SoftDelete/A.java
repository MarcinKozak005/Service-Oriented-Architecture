package SoftDelete;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@SQLDelete(sql ="UPDATE a SET deleted = true WHERE id = ?")
@Loader(namedQuery = "findByIdA")
@NamedQuery(name = "findByIdA", query ="SELECT x FROM A x WHERE x.id = ?1 AND x.deleted = false")
@Where(clause = "deleted = false")
public class A {  //Category
    @Id
    @GeneratedValue
    int id;

    @Version
    private int version;

    String a_name;

    @OneToMany(mappedBy = "a")
    List<B> a_b = new LinkedList<B>();

    boolean deleted=false;

    @PreRemove
    public void removePreparation()
    {
        for (B b: a_b){
            b.setA(null);
        }
    }

}
