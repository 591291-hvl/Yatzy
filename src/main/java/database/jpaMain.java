package database;


import javax.persistence.*;
import java.util.List;

public class jpaMain {

    public static void main(String[] args){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("personUnit");
        EntityManager em = emf.createEntityManager();

        String name = "Daniel";

        try{
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.name = '" + name + "'", Person.class);
            List<Person> persons = query.getResultList();



            for(Person p: persons){
                System.out.println(p + "<---");

            }

        } finally {
            emf.close();
            em.close();
        }

    }
}
