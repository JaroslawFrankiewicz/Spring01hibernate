package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void createAuthor(Author author) {
        entityManager.persist(author);
    }
    public void updateAuthor(Author author) {
        entityManager.merge(author);
    }
    public Author readAuthor(long id) {
        return entityManager.find(Author.class, id);
    }
    public void deleteAuthor(Author author) {
        entityManager.remove(entityManager.contains(author) ?
                author : entityManager.merge(author)); }

    public List<Author> findAll(){
        Query query = entityManager.createQuery("SELECT a FROM Author a");
        return query.getResultList();
    }

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }
}
