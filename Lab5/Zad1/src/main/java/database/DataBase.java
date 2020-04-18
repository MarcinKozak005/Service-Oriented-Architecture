package database;

import api.DataBaseAPI;

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


    public List<BooksTableEntity> getAllBooks()
    {
        try {
            Query q = em.createQuery("FROM BooksTableEntity ", BooksTableEntity.class);
            return (List<BooksTableEntity>) q.getResultList();
        }
        catch(Exception e) {
            System.err.println("An error occurred during selecting entities: " + e);
        }
        return null;
    }

    public void addBook(BooksTableEntity book)
    {
        try {
            // transaction-type="JTA" in persistance.xml handles transaction
            em.persist(book);
        }
        catch (Exception e) {
            System.err.println("An error occurred during addition of a book: "+book+"\n"+ e);
        }
    }

    public void deleteBookById(int toDeleteId) {
        try {
            // transaction-type="JTA" in persistance.xml handles transaction
            BooksTableEntity booksTableEntity = em.find(BooksTableEntity.class,toDeleteId);
            em.remove(booksTableEntity);
        }catch (Exception e){
            System.err.println("An error occurred during book deletion. Id: "+toDeleteId+"\n"+e);
        }
    }

    public void updateBook(int toUpdateId, BooksTableEntity schema) {
        try {
            // transaction-type="JTA" in persistance.xml handles transaction
            BooksTableEntity updateObject = em.find(BooksTableEntity.class,toUpdateId);
            if(schema.getAuthorName()!=null) updateObject.setAuthorName(schema.getAuthorName());
            if(schema.getAuthorSurname()!=null) updateObject.setAuthorSurname(schema.getAuthorSurname());
            if(schema.getBookTitle()!=null) updateObject.setBookTitle(schema.getBookTitle());
            if(schema.getIsbnNumber()!=null) updateObject.setIsbnNumber(schema.getIsbnNumber());
            if(schema.getDateOfIssue()!=null) updateObject.setDateOfIssue(schema.getDateOfIssue());
            if(schema.getPrice()!=null) updateObject.setPrice(schema.getPrice());
            em.persist(updateObject);
        }catch (Exception e)
        {
            System.err.println("An error occurred during updating a book object. Id = "+toUpdateId+"\n"+e);
        }
    }
}
