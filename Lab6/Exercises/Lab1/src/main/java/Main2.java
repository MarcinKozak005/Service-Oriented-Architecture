import OneToOne.Dog;
import OneToOne.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main2 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceName1");
        EntityManager em = factory.createEntityManager();

        try {
            Dog dog = em.find(Dog.class,1);
            Owner owner = dog.getMyOwner();
            System.out.println("I'm owned by:" + owner.getName());
        }
        catch(Exception e) {
            System.err.println("An error occurred during selecting entities: " + e);
        }
    }
}
