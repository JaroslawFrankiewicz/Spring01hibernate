package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class PersonDao {
    @PersistenceContext
    private EntityManager entityManager;
    public Person save(Person person) {
        entityManager.persist(person);
        return person;
    }


    public Person createPerson(Person person) {
        entityManager.persist(person);
        return person;
    }
    public void updatePerson(Person person) {
        entityManager.merge(person);
    }
    public Person readPerson(long id) {
        return entityManager.find(Person.class, id);
    }
    public void deletePerson(Person person) {
        entityManager.remove(entityManager.contains(person) ?
                person : entityManager.merge(person)); }

}
