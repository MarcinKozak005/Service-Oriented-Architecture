package database;

import api.BookAPI;
import model.Book;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@Local(BookAPI.class)
public class BookDB implements BookAPI{
    
    @PersistenceContext(name = "PersistenceName1")
    EntityManager em;
    
    public List<Book> getAllBooks() {
        TypedQuery<Book> bookTypedQuery = (TypedQuery<Book>) em.createNamedQuery("BookGetAllBooks");
        return bookTypedQuery.getResultList();
    }

    public void addBook(Book book) {
        try {
            em.persist(book);
        }
        catch (Exception e)
        {
            System.err.println("EXCEPTION Add Book: " + e);
        }
    }

    public void deleteBook(int id) {
        try {
            Book book = em.find(Book.class,id);
            em.remove(book);
        }
        catch(Exception e) {
            System.err.println("EXCEPTION Delete Book: " + e);
        }
    }

    public void updateBook(int id, Book book) {
        try
        {
            Book bookFromDB = em.find(Book.class,id);
            if(!book.getBook_title().equals("")) bookFromDB.setBook_title(book.getBook_title());
            if(book.getBook_author()!=null) bookFromDB.setBook_author(book.getBook_author());
            if(book.getBook_category()!=null) bookFromDB.setBook_category(book.getBook_category());
            if(!book.getIsbn().equals("")) bookFromDB.setIsbn(book.getIsbn());

            em.persist(bookFromDB);
        }
        catch (Exception e)
        {
            System.err.println("EXCEPTION Update Book: " + e);
        }
    }

    public Book getBook(int id) {
        try
        {
            Book book = em.find(Book.class,id);
            return book;
        }
        catch (Exception e)
        {
            System.err.println("EXCEPTION Get Book: " + e);
        }
        return null;
    }
}
