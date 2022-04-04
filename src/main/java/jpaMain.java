import dao.PersonDAO;
import entity.PersonEntity;
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

        PersonDAO pDAO = new PersonDAO();

        PersonEntity p1 = new PersonEntity("003", "Petter");
        pDAO.savePerson(p1);

        List<PersonEntity> persons = pDAO.getAllPersons();

        for(PersonEntity p : persons){
            System.out.println(p + "<-----");
        }



    }
}
