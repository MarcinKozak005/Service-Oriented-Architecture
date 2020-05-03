package beans;

import api.AuthorAPI;
import api.BookAPI;
import api.CategoryAPI;
import lombok.Getter;
import lombok.Setter;
import model.Book;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "BookBean")
@RequestScoped
@Getter
@Setter
public class BookBean {
    
    @EJB
    BookAPI bookAPI;
    @EJB
    CategoryAPI categoryAPI;
    @EJB
    AuthorAPI authorAPI;

    int id;
    String title;
    String isbn;
    int categoryId;
    int authorId;
    // TODO

    List<Book> filteredValues;

    public List<Book> getAllBooks(){ return bookAPI.getAllBooks();}
    public void addBook()
    {
        Book book = new Book();
        book.setBook_title(this.title);
        book.setIsbn(this.isbn);
        book.setBook_category(categoryAPI.findCategory(this.categoryId));
        book.setBook_author(authorAPI.findAuthor(this.authorId));
        bookAPI.addBook(book);
    }

    public void deleteBook()
    {
        bookAPI.deleteBook(this.id);
    }
    public void updateBook()
    {
        Book book = new Book();
        book.setBook_title(this.title);
        book.setIsbn(this.isbn);
        book.setBook_category(categoryAPI.findCategory(this.categoryId));
        book.setBook_author(authorAPI.findAuthor(this.authorId));
        bookAPI.updateBook(id, book);
    }
}
