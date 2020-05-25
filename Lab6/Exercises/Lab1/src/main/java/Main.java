import OneToMany.Hero;
import OneToMany.Weapon;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceName1");

        EntityManager em = factory.createEntityManager();

        try {

            // InheritanceMapping.Book - InheritanceMapping.Comic Example
            // Inheritance mapping

            /*InheritanceMapping.Book s1 = new InheritanceMapping.Book();
            s1.setAuthor("Author1");
            s1.setTitle("Title1");
            InheritanceMapping.Comic s2 = new InheritanceMapping.Comic();
            s2.setAuthor("Author2");
            s2.setTitle("Title2");
            s2.setIllustrator("Illustrator2");

            em.getTransaction().begin();
            em.persist(s1);
            em.persist(s2);
            em.getTransaction().commit();
            System.out.println("Saved into DB "+ s1);
            System.out.println("Saved into DB "+ s2);*/


            // OneToOne.Owner - OneToOne.Dog
            // Relations mapping
            /*OneToOne.Owner owner = new OneToOne.Owner();
            owner.setName("Tom");
            OneToOne.Dog dog = new OneToOne.Dog();
            dog.setDogName("Sparky");
            owner.setDog(dog);

            em.getTransaction().begin();
            em.persist(owner);
            em.persist(dog);
            em.getTransaction().commit();*/


            //OneToMany.Hero - OneToMany.Weapon
            /*Hero hero = new Hero();
            hero.setHeroName("Knight");
            Weapon w1 = new Weapon();
            Weapon w2 = new Weapon();
            w1.setWeaponName("Sword");
            w2.setWeaponName("Shield");
            w1.setOwner(hero);
            w2.setOwner(hero);

            em.getTransaction().begin();
            em.persist(hero);
            em.persist(w1);
            em.persist(w2);
            em.getTransaction().commit();*/


        }catch (Exception e)
        {
            System.err.println("Exception occurred");
        }
    }
}
