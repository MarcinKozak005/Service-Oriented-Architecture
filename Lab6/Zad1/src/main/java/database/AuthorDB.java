package database;

import api.AuthorAPI;
import model.Author;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@Local(AuthorAPI.class)
public class AuthorDB implements AuthorAPI{

    @PersistenceContext(name = "PersistenceName1")
    EntityManager em;

    public List<Author> getAllAuthors() {
        TypedQuery<Author> authorQuery = (TypedQuery<Author>) em.createNamedQuery("AuthorGetAllAuthors");
        return authorQuery.getResultList();
    }

    public void addAuthor(Author author) {
        try {
            em.persist(author);
        }
        catch (Exception e)
        {
            System.err.println("EXCEPTION Add Author: " + e);
        }
    }

    public void deleteAuthor(int id) {
        try {
            Author author = em.find(Author.class,id);
            em.remove(author);
        }
        catch(Exception e) {
            System.err.println("EXCEPTION Delete Author: " + e);
        }
    }

    public void updateAuthor(int id, Author author) {
        try
        {
            Author authorFromDB = em.find(Author.class,id);
            if(!author.getAuthor_name().equals("")) authorFromDB.setAuthor_name(author.getAuthor_name());
            if(!author.getAuthor_surname().equals("")) authorFromDB.setAuthor_surname(author.getAuthor_surname());
            em.persist(authorFromDB);
        }
        catch (Exception e)
        {
            System.err.println("EXCEPTION Update Author: " + e);
        }
    }

    public Author findAuthor(int authorId) {
        try
        {
            Author authorFromDB = em.find(Author.class,authorId);
            return authorFromDB;
        }
        catch (Exception e)
        {
            System.err.println("EXCEPTION Update Author: " + e);
        }
        return null;
    }
}
