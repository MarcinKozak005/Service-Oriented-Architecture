package TestJPQL;

import OneToOne.Owner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JPQLMain {
    public static void main(String[] args) {

        EntityManager entityManager = Persistence.createEntityManagerFactory("PersistenceName1").createEntityManager();

        // JPQL Query No.1
        /*String jpql = "SELECT h.heroName FROM Hero h WHERE h.heroId = 1";
        TypedQuery query = entityManager.createQuery(jpql,String.class);
        System.out.println("Hero name: " + query.getSingleResult());*/

        // Named Query
        /*TypedQuery<Object[]> query = (TypedQuery<Object[]>)entityManager.createNamedQuery("getAllOwnersNamesWithDogs");
        List<Object[]> res = query.getResultList();

        for( Object[] o : res ) {
            System.out.println("Owner name: " + o[0] );
            System.out.println("Dog name: " + o[1] );
        }*/

        // JPQL Query
        /*String jpql = "SELECT o.name FROM Owner o WHERE o.id = :id";
        Query query = entityManager.createQuery(jpql,String.class).setParameter("id", new Integer(1));

        System.out.println("Owner name: "+query.getSingleResult());*/

        // Criteria Queries
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Owner> query = cb.createQuery(Owner.class);

        Root<Owner> hh = query.from(Owner.class);
        query.select(hh).where(cb.equal(hh.get("id"), 1));

        TypedQuery<Owner> tq = entityManager.createQuery(query);
        System.out.println("Owner name: "+ tq.getSingleResult().getName());


    }
}
