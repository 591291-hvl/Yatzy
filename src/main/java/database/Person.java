package database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(schema = "yatzy")
@NamedQuery(name = "getAllPersons", query = "SELECT p FROM Person p")
public class Person {

    @Id
    private String id;
    private String name;


    public Person() {

    }

    public Person(String id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
