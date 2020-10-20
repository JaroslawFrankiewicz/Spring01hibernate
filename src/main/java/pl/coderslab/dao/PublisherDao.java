package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void createPublisher(Publisher publisher) {
        entityManager.persist(publisher);
    }
    public void updatePublisher(Publisher publisher) {
        entityManager.merge(publisher);
    }
    public Publisher readPublisher(long id) {
        return entityManager.find(Publisher.class, id);
    }
    public void deletePublisher(Publisher publisher) {
        entityManager.remove(entityManager.contains(publisher) ?
                publisher : entityManager.merge(publisher)); }

    public List<Publisher> findAll(){
        Query query = entityManager.createQuery("SELECT p FROM Publisher p");
        return query.getResultList();
    }


}
