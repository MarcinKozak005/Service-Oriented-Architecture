import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceName1");

        EntityManager em = factory.createEntityManager();

        try {
            Student s1 = new Student("John","Wick", new Date());
            Student s2 = new Student("Agent","47", new Date());
            Student s3 = new Student("James","Bond", new Date());

            em.getTransaction().begin();
            em.persist(s1);
            em.persist(s2);
            em.persist(s3);
            em.getTransaction().commit();
            System.out.println("Saved into DB "+ s1);
            System.out.println("Saved into DB "+ s2);
            System.out.println("Saved into DB "+ s3);

        }catch (Exception e)
        {
            System.err.println("Exception occurred");
        }
    }
}
