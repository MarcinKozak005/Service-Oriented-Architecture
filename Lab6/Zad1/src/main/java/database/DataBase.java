package database;

import api.DataBaseAPI;
import model.*;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Local(DataBaseAPI.class)
public class DataBase implements DataBaseAPI
{
    @PersistenceContext(name = "PersistenceName1")
    private EntityManager em;


    public List<Author> getAllAuthors()
    {
        try {
            Query q = em.createQuery("FROM Author ", Author.class);
            return (List<Author>) q.getResultList();
        }
        catch(Exception e) {
            System.err.println("An error occurred during selecting entities: " + e);
        }
        return null;
    }

    public List<Book> getAllBooks() {
        try {
            Query q = em.createQuery("FROM Book ", Book.class);
            return (List<Book>) q.getResultList();
        }
        catch(Exception e) {
            System.err.println("An error occurred during selecting entities: " + e);
        }
        return null;
    }

    public List<Category> getAllCategories() {
        try {
            Query q = em.createQuery("FROM Category ", Category.class);
            return (List<Category>) q.getResultList();
        }
        catch(Exception e) {
            System.err.println("An error occurred during selecting entities: " + e);
        }
        return null;
    }

    public List<Loan> getAllLoans() {
        try {
            Query q = em.createQuery("FROM Loan ", Loan.class);
            return (List<Loan>) q.getResultList();
        }
        catch(Exception e) {
            System.err.println("An error occurred during selecting entities: " + e);
        }
        return null;
    }

    public List<Reader> getAllReaders() {
        try {
            Query q = em.createQuery("FROM Reader ", Reader.class);
            return (List<Reader>) q.getResultList();
        }
        catch(Exception e) {
            System.err.println("An error occurred during selecting entities: " + e);
        }
        return null;
    }

    public List<Specimen> getAllSpecimens() {
        try {
            Query q = em.createQuery("FROM Specimen ", Specimen.class);
            return (List<Specimen>) q.getResultList();
        }
        catch(Exception e) {
            System.err.println("An error occurred during selecting entities: " + e);
        }
        return null;
    }

//    public List<Object> specialQuery()
//    {
//        try {
//            Query q = em.createQuery("FROM Specimen ", Specimen.class);
//            return (List<Specimen>) q.getResultList();
//        }
//        catch(Exception e) {
//            System.err.println("An error occurred during selecting entities: " + e);
//        }
//        return null;
//    }


//    public void addBook(BooksTableEntity book)
//    {
//        try {
//            // transaction-type="JTA" in persistence.xml handles transaction
//            em.persist(book);
//        }
//        catch (Exception e) {
//            System.err.println("An error occurred during addition of a book: "+book+"\n"+ e);
//        }
//    }
//
//    public void deleteBookById(int toDeleteId) {
//        try {
//            // transaction-type="JTA" in persistence.xml handles transaction
//            BooksTableEntity booksTableEntity = em.find(BooksTableEntity.class,toDeleteId);
//            em.remove(booksTableEntity);
//        }catch (Exception e){
//            System.err.println("An error occurred during book deletion. Id: "+toDeleteId+"\n"+e);
//        }
//    }
//
//    public void updateBook(int toUpdateId, BooksTableEntity schema) {
//        try {
//            // transaction-type="JTA" in persistence.xml handles transaction
//            BooksTableEntity updateObject = em.find(BooksTableEntity.class,toUpdateId);
//            if(schema.getAuthorName()!=null) updateObject.setAuthorName(schema.getAuthorName());
//            if(schema.getAuthorSurname()!=null) updateObject.setAuthorSurname(schema.getAuthorSurname());
//            if(schema.getBookTitle()!=null) updateObject.setBookTitle(schema.getBookTitle());
//            if(schema.getIsbnNumber()!=null) updateObject.setIsbnNumber(schema.getIsbnNumber());
//            if(schema.getDateOfIssue()!=null) updateObject.setDateOfIssue(schema.getDateOfIssue());
//            if(schema.getPrice()!=null) updateObject.setPrice(schema.getPrice());
//            em.persist(updateObject);
//        }catch (Exception e)
//        {
//            System.err.println("An error occurred during updating a book object. Id = "+toUpdateId+"\n"+e);
//        }
//    }
}
