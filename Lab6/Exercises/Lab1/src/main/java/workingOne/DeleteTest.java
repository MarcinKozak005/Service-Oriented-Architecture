package workingOne;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DeleteTest {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("PersistenceName1").createEntityManager();

        workingOne.A a = new workingOne.A();
        a.setA_name("Reader1");
        a.setDeleted(false);
        workingOne.B b1 = new workingOne.B();
        b1.setB_name("Loan1");
        b1.setDeleted(false);
        workingOne.B b2 = new B();
        b2.setB_name("Loan2");
        b2.setDeleted(false);
//        a.getA_b().add(b1);
//        a.getA_b().add(b2);
        b1.setA(a);
        b2.setA(a);

        try {
//            em.getTransaction().begin();
//            em.persist(a);
//            em.persist(b1);
//            em.persist(b2);
//            em.getTransaction().commit();

//            em.getTransaction().begin();
//            em.remove(a);
//            em.getTransaction().commit();


            em.getTransaction().begin();
            em.remove(em.find(A.class,160));
            em.getTransaction().commit();
        }catch (Exception e){
            System.err.println(e);
        }


    }
}

