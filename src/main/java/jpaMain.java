import dao.PersonDAO;
import entity.PersonEntity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.Persistence;

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
        /*pDAO.savePerson(p1);

        List<PersonEntity> persons = pDAO.getAllPersons();

        for(PersonEntity p : persons){
            System.out.println(p + "<-----");
        }*/



    }
}
