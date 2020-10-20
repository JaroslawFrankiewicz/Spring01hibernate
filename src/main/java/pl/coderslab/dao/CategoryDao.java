package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Category;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {
    @PersistenceContext
    EntityManager entityManager;

    public Category readCategory(long id) {
        return entityManager.find(Category.class, id);
    }
    public void createCategory(Category category) {
        entityManager.persist(category);
    }
    public List<Category> findAll() {
        Query query = entityManager.createQuery("SELECT c FROM Category c");
        return query.getResultList();
    }
}
