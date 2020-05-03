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
@SQLDelete(sql ="UPDATE book SET deleted = true WHERE book_id = ?")
@Loader(namedQuery = "findByIdBook")
@NamedQueries({
        @NamedQuery(name = "findByIdBook", query = "SELECT b FROM Book b WHERE b.book_id = ?1 AND b.deleted = false"),
        @NamedQuery(name="BookGetAllBooks", query = "SELECT b FROM Book b ORDER BY b.book_id")
})
@Where(clause = "deleted = false")
public class Book {
    @Id
    @GeneratedValue
    private int book_id;
    private String book_title;
    private String isbn; // leading zeros

    boolean deleted = false;

    @ManyToOne
    private Category book_category;

    @ManyToOne
    private Author book_author;

    // Not owned
    @OneToMany(mappedBy = "specimen_book", cascade = CascadeType.REMOVE)
    private List<Specimen> book_specimens;

}
