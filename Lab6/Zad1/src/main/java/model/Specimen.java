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
@SQLDelete(sql ="UPDATE specimen SET deleted = true WHERE specimen_id = ?")
@Loader(namedQuery = "findByIdSpecimen")
@NamedQueries({
        @NamedQuery(name = "findByIdSpecimen", query = "SELECT s FROM Specimen s WHERE s.specimen_id = ?1 AND s.deleted = false"),
        @NamedQuery(name = "SpecimenGetAllSpecimens", query = "SELECT s FROM Specimen s ORDER BY s.specimen_id"),
        @NamedQuery(name = "SpecimenGetJoinedSpecimens",query ="SELECT b.book_title,\n" +
                "       a.author_name || ' ' || a.author_surname,\n" +
                "       c.category_name,\n" +
                "       b.isbn,\n" +
                "       s.specimen_id,\n"+
                "       s "+
                "FROM Book b\n" +
                "    JOIN Category c ON b.book_category = c\n" +
                "    JOIN Author a ON b.book_author = a\n" +
                "    JOIN Specimen s ON s.specimen_book = b\n" +
                "WHERE s.deleted = false" )
})
@Where(clause = "deleted = false")
public class Specimen {
    @Id
    @GeneratedValue
    private int specimen_id;

    @ManyToOne
    private Book specimen_book;

    private boolean free;
    boolean deleted = false;

    // Not owned
    @OneToMany(mappedBy = "loan_specimen", cascade = CascadeType.REMOVE)
    private List<Loan> specimen_loans;
}
