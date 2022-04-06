package dao;

import entity.PersonEntity;

import java.beans.JavaBean;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonDAO {

    @PersistenceContext(name = "personUnit")
    private EntityManager em;

    public synchronized List<PersonEntity> getAllPersons() {
        return em.createQuery("SELECT p FROM PersonEntity p", PersonEntity.class).getResultList();
    }

    public void savePerson(PersonEntity person) {
        em.persist(person);
    }
}
