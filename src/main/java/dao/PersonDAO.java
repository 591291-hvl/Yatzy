package dao;

import entity.PersonEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PersonDAO {
    private EntityManagerFactory emf;

    public PersonDAO() {
        emf = Persistence.createEntityManagerFactory("PersonUnit");
    }


    public List<PersonEntity> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        List<PersonEntity> persons = null;
        try {
            TypedQuery<PersonEntity> query = em.createQuery("Select p from PersonEntity p", PersonEntity.class);
            persons = query.getResultList();
        } finally {
            em.close();
        }
        return persons;
    }
}

