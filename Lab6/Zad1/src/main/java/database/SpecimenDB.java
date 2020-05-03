package database;

import api.SpecimenAPI;
import model.Specimen;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@Local(SpecimenAPI.class)
public class SpecimenDB implements SpecimenAPI {

    @PersistenceContext(name = "PersistenceName1")
    EntityManager em;


    public List<Specimen> getAllSpecimens() {
        TypedQuery<Specimen> typedQuery = (TypedQuery<Specimen>) em.createNamedQuery("SpecimenGetAllSpecimens");
        return typedQuery.getResultList();
    }

    public List<Object[]> getSpecimensForLoan() {
        TypedQuery<Object[]> typedQuery = (TypedQuery<Object[]>) em.createNamedQuery("SpecimenGetJoinedSpecimens");
        return typedQuery.getResultList();
    }

    public void addSpecimen(Specimen specimen) {
        try {
            em.persist(specimen);
        }
        catch (Exception e)
        {
            System.err.println("EXCEPTION Add Specimen: " + e);
        }
    }

    public void deleteSpecimen(int id) {
        try {
            Specimen specimen = em.find(Specimen.class,id);
            em.remove(specimen);
        }
        catch(Exception e) {
            System.err.println("EXCEPTION Delete Specimen: " + e);
        }
    }

    public void updateSpecimen(int id, Specimen specimen) {
        try
        {
            Specimen specimenFromDB = em.find(Specimen.class,id);
            if(specimen.getSpecimen_book()!=null) specimenFromDB.setSpecimen_book(specimen.getSpecimen_book());
            if(specimen.isFree()!=specimenFromDB.isFree()) specimenFromDB.setFree(specimen.isFree());
            em.persist(specimenFromDB);
        }
        catch (Exception e)
        {
            System.err.println("EXCEPTION Update Specimen: " + e);
        }
    }

    public Specimen getSpecimen(int id) {
        try{
            Specimen specimen = em.find(Specimen.class, id);
            return specimen;
        }catch (Exception e){
            System.err.println("EXCEPTION Get Specimen:" +e);
        }
        return null;
    }
}
