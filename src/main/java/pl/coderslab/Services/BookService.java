package pl.coderslab.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Category;
import pl.coderslab.model.Publisher;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Transactional
@AllArgsConstructor
@Service
public class BookService {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    public Book addBook() {
        Book book = new Book();
        book.setTitle("Thinking in Java ");
        Publisher publisher = new Publisher();
        publisher.setName("publisher");
        publisherDao.createPublisher(publisher);
        book.setPublisher(publisher);

        Book book1 = new Book();
        book.setTitle("test");
        Author author = new Author();
        author.setFirstName("1");
        Author author1 = new Author();
        author1.setFirstName("2");
        authorDao.createAuthor(author);
        authorDao.createAuthor(author1);
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        authors.add(author1);
        book.setAuthors(authors);
//        Book persistedBook = bookDao.save(book);
        return book1;
    }

//        public Book addBook() {
//        Book book = new Book();
//        book.setTitle("Thinking in Java ");
//        Publisher publisher = new Publisher();
//        publisher.setName("publisher");
//        publisherDao.savePublisher(publisher);
//        book.setPublisher(publisher);
//        Author author = new Author();
//        Author author1 = new Author();
//        author.setFirstName("Bruce");
//        author.setLastName("Lee");
//        author1.setFirstName("John");
//        author1.setLastName("Wayne");
//        List<Author> authorList = new ArrayList<>();
//        authorList.add(author);
//        authorList.add(author1);
//        authorDao.saveAuthor(author);
//        authorDao.saveAuthor(author1);
//        book.setAuthors(authorList);
//
//        bookDao.saveBook(book);
//        return book;
//    }

    public Book findById(long id) {
        return bookDao.findById(id);
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }
    public List<Book> findAllByRating(int rating) {
        return bookDao.findByRating(rating);
    }
    public List<Book> findAllWithPublisher(long id) {
        return bookDao.findAllWithPublisher(id);
    }
//    public List<Book> findAllWithAuthor(long id) {
//        return bookDao.findAllWithAuthor(id);
//    }
    public List<Book> findAllWithCategory(long id) {
        return bookDao.findAllWithCategory(id);
    }
}
