package database;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class jpaMain {

    public static void main(String[] args){
        try {
            System.out.println(Class.forName("org.postgresql.Driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonUnit");
        EntityManager em = emf.createEntityManager();
        //String name = "Daniel";

        try{

            TypedQuery<PersonEntity> query = em.createQuery("SELECT p FROM PersonEntity p", PersonEntity.class);
            List<PersonEntity> persons = query.getResultList();

            for(PersonEntity p: persons){
                System.out.println(p + "<---");
            }

        } catch (Exception e){
            System.out.println("===============================");
            System.out.println(e);
            System.out.println("===============================");
        } finally {
            em.close();
            emf.close();

        }

    }
}
