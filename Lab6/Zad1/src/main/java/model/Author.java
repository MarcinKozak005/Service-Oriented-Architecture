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
@SQLDelete(sql ="UPDATE author SET deleted = true WHERE author_id = ?")
@Loader(namedQuery = "findByIdAuthor")
@NamedQueries({
        @NamedQuery(name = "findByIdAuthor", query = "SELECT a FROM Author a WHERE a.author_id = ?1 AND a.deleted = false"),
        @NamedQuery(name = "AuthorGetAllAuthors", query = "SELECT a FROM Author a ORDER BY a.author_name")
})
@Where(clause = "deleted = false")
public class Author {
    @Id
    @GeneratedValue
    private int author_id;
    private String author_name;
    private String author_surname;

    boolean deleted = false;

    @OneToMany(mappedBy = "book_author")
    private List<Book> author_books;

    @PreRemove
    public void clearBooksFromAuthor()
    {
        for(Book book: author_books)
            book.setBook_author(null);
    }
}
