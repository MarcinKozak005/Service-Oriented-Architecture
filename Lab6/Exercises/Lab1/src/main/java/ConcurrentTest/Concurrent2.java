package ConcurrentTest;

import SoftDelete.A;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.Persistence;

import static java.lang.Thread.sleep;

public class Concurrent2 implements Runnable{

    public void run() {
        EntityManager em = Persistence.createEntityManagerFactory("PersistenceName1").createEntityManager();

        try {
            System.out.println("2Before find");
            A a = em.find(A.class, 189);
            System.out.println("2After find");
            a.setA_name("Wrong one");
            sleep(4000);
            System.out.println("End of sleep 2");
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        }catch (InterruptedException e){
            System.out.println(e);
        }catch (Exception x)
        {
            System.out.println("Optimistic lock exception");
        }
    }
}
