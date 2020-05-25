package SoftDelete;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DeleteTest {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("PersistenceName1").createEntityManager();

        A a = new A();
        a.setA_name("Cat1");

        B b1 = new B();
        b1.setB_name("Book1");
        B b2 = new B();
        b2.setB_name("Book2");
        B b3 = new B();
        b3.setB_name("Book3");
        b1.setA(a);
        b2.setA(a);
//        C c1 = new C();
//        c1.setC_name("Loan1");
//        C c2 = new C();
//        c2.setC_name("Loan2");
//        C c3 = new C();
//        c3.setC_name("Loan3");
//        c1.setB(b1);
//        c2.setB(b2);
//        c3.setB(b2);


        //----
        A z = new A();
        z.setA_name("ZZ");
        b3.setA(z);



//        a.getA_b().add(b1);
//        a.getA_b().add(b2);


        try {
            em.getTransaction().begin();
            em.persist(a);
            em.persist(b1);
            em.persist(b2);
            em.persist(b3);
            em.persist(z);
            em.getTransaction().commit();

//            em.getTransaction().begin();
//            em.remove(a);
//            em.getTransaction().commit();


//            em.getTransaction().begin();
//            em.remove(em.find(A.class,180));
//            em.getTransaction().commit();
        }catch (Exception e){
            System.err.println(e);
        }


    }
}

