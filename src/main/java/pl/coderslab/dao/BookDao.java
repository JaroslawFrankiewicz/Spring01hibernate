package pl.coderslab.dao;

import org.hibernate.sql.Select;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;

//    public Book save(Book book) {
//        entityManager.persist(book);
//        return book;
//    }
@Transactional
public void save(Book book) {
    if (book.getId() == null) {
        entityManager.persist(book);
    } else {
        entityManager.merge(book);
    }
}

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

//    public void deleteById(Book book) {
//        entityManager.remove(entityManager.contains(book) ?
//                book : entityManager.merge(book));
//    }
    public List<Book> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        return query.getResultList();
    }

//    public List<Book> findAll() {
//        Query query = entityManager.createQuery("SELECT b FROM Book b JOIN FETCH b.authors ");
//        return query.getResultList();
//    }

    public List<Book> findByRating(int rating) {
        Query query = entityManager.createQuery("SELECT b from Book b where b.rating > :rating");
        query.setParameter("rating", rating);
        return query.getResultList();
    }

    public List<Book> findAllWithPublisher(long id) {
        Query query = entityManager.createQuery("SELECT b from Book b JOIN FETCH b.publisher where b.publisher.id =:publisher");
        query.setParameter("publisher", id);
        return query.getResultList();
    }

//    public List<Book> findAllWithAuthor(long id) {
//        Query query = entityManager.createQuery("SELECT b from Book b JOIN FETCH b.author where b.author.id =:author");
//        query.setParameter("author", id);
//        return query.getResultList();
//    }
    public List<Book> findAllWithCategory(long id) {
        Query query = entityManager.createQuery("SELECT b from Book b JOIN FETCH b.category where b.category.id =:category");
        query.setParameter("category", id);
        return query.getResultList();
    }
    @Transactional
    public void deleteById(Long id) {
        Book book = entityManager.find(Book.class, id);
        entityManager.remove(book);
    }



    // Zadanie 3 od Tomka Kalwasińskiego ->
    public List<Book> hasPublisher() {
        Query queryp = entityManager.
                createQuery("SELECT b FROM Book b JOIN b.publisher WHERE b.publisher.id IS NOT NULL");
        return queryp.getResultList();
    }


    public List<Book> hasPublisherNamed(String name) {
        Query queryp = entityManager.
                createQuery("SELECT b FROM Book b JOIN b.publisher where b.publisher.name =:name");
        queryp.setParameter("name", name);
        List<Book> booksp = queryp.getResultList();
        return queryp.getResultList();
    }

    public List<Book> hasAuthorNamed(String lastName) {
        Query queryp = entityManager.
                createQuery("SELECT b FROM Book b JOIN b.authors a where a.lastName =:lastName");
        queryp.setParameter("lastName", lastName);
        List<Book> booksp = queryp.getResultList();
        return queryp.getResultList();
    }
}


//    public Book findById(long id) {
//        return entityManager.find(Book.class, id);
//    }
//
//    public ArrayList<Book> findAll() {
//        Query query = entityManager.createQuery("SELECT b FROM Book b");
//        return (ArrayList<Book>) query.getResultList();
//
//    }
//
//
//    public List<Book> findByRating(int rating) {
//        Query queryp = entityManager.
//                createQuery("SELECT b FROM Book b where b.rating >:rating");
//        queryp.setParameter("rating", rating);
//        List<Book> booksp = queryp.getResultList();
//        return queryp.getResultList();
//    }
//
//    public List<Book> hasPublisher() {
//        Query queryp = entityManager.
//                createQuery("SELECT b FROM Book b JOIN b.publisher WHERE b.publisher.id IS NOT NULL");
//        return queryp.getResultList();
//    }
//
//    public List<Book> hasPublisherNamed(String name) {
//        Query queryp = entityManager.
//                createQuery("SELECT b FROM Book b JOIN b.publisher where b.publisher.name =:name");
//        queryp.setParameter("name", name);
//        List<Book> booksp = queryp.getResultList();
//        return queryp.getResultList();
//    }
//
//    public List<Book> hasAuthorNamed(String lastName) {
//        Query queryp = entityManager.
//                createQuery("SELECT b FROM Book b JOIN b.authors a where a.lastName =:lastName");
//        queryp.setParameter("lastName", lastName);
//        List<Book> booksp = queryp.getResultList();
//        return queryp.getResultList();
//    }
//
//    public void update(Book book) {
//        entityManager.merge(book);
//
//    }
//
//    public void delete(Book book) {
//        entityManager.remove(entityManager.contains(book) ?
//                book : entityManager.merge(book));
//    }
//
//    public void deleteById(Long id) {
//        Book book = entityManager.find(Book.class, id);
//        entityManager.remove(entityManager.contains(book) ?
//                book : entityManager.merge(book));
//    }
//    @Transactional
//    public void saveBook(Book book) {
//        if (book.getId() == null) {
//            entityManager.persist(book);
//        } else {
//            entityManager.merge(book);
//        }
//    }