package database;

import api.ReaderAPI;
import model.Reader;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@Local(ReaderAPI.class)
public class ReaderDB implements ReaderAPI {

    @PersistenceContext(name = "PersistenceName1")
    private EntityManager em;

    public List<Reader> getAllReaders() {
        TypedQuery<Reader> readerQuery = (TypedQuery<Reader>) em.createNamedQuery("ReaderGetAllReaders");
        return readerQuery.getResultList();
    }

    public void addReader(Reader reader) {
        try {
            em.persist(reader);
        }
        catch(Exception e) {
            System.err.println("EXCEPTION Add Reader: " + e);
        }
    }

    public void deleteReader(int id) {
        try {
            Reader reader = em.find(Reader.class,id);
            em.remove(reader);
        }
        catch(Exception e) {
            System.err.println("EXCEPTION Delete Reader: " + e);
        }
    }

    public void updateReader(int id, Reader reader)
    {
        try
        {
            Reader readerFromDB = em.find(Reader.class,id);
            if(!reader.getReader_name().equals("")) readerFromDB.setReader_name(reader.getReader_name());
            if(!reader.getReader_surname().equals("")) readerFromDB.setReader_surname(reader.getReader_surname());
            em.persist(readerFromDB);
        }
        catch (Exception e)
        {
            System.err.println("EXCEPTION Update Reader: " + e);
        }
    }

    public Reader getReader(int id) {
        try
        {
            Reader reader = em.find(Reader.class,id);
            return reader;
        }catch (Exception e)
        {
            System.err.println("EXCEPTION get Reader: "+ e);
        }
        return null;
    }
}
