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
@SQLDelete(sql ="UPDATE category SET deleted = true WHERE category_id = ?")
@Loader(namedQuery = "findByIdCategory")
@NamedQueries({
        @NamedQuery(name = "findByIdCategory", query = "SELECT c FROM Category c WHERE c.category_id = ?1 AND c.deleted = false"),
        @NamedQuery(name = "CategoryGetAllCategories", query = "SELECT c FROM Category c ORDER BY c.category_id")
})
@Where(clause = "deleted = false")
public class Category {
    @Id
    @GeneratedValue
    private int category_id;
    private String category_name;

    @OneToMany(mappedBy = "book_category")
    private List<Book> category_books;

    boolean deleted = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return category_id == category.category_id;
    }

    @PreRemove
    public void clearBooksInCategory()
    {
        for (Book book: category_books)
            book.setBook_category(null);
    }
}
