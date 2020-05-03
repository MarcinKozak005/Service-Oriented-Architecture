package model;



import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
// Soft delete annotations
@SQLDelete(sql ="UPDATE reader SET deleted = true WHERE reader_id = ?")
@Loader(namedQuery = "findByIdReader")
@NamedQueries({
        @NamedQuery(name = "findByIdReader", query = "SELECT r FROM Reader r WHERE r.reader_id = ?1 AND r.deleted = false"),
        @NamedQuery(name = "ReaderGetAllReaders", query = "SELECT r FROM Reader r ORDER BY r.reader_name")
})
@Where(clause = "deleted = false")
public class Reader {
    @Id
    @GeneratedValue
    private int reader_id;
    private String reader_name;
    private String reader_surname;

    boolean deleted = false;

    // Not owned
    @OneToMany(mappedBy ="loan_reader", cascade = CascadeType.REMOVE)
    private List<Loan> reader_loans;
}
