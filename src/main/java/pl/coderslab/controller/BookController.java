package pl.coderslab.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.*;
import pl.coderslab.dao.BookDao;
import pl.coderslab.repository.BookRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("books")
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final BookRepository bookRepository;
    private final CategoryDao categoryDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao, BookRepository bookRepository, CategoryDao categoryDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.bookRepository = bookRepository;
        this.categoryDao = categoryDao;
    }
//    metodę wyszukującą książki dla zadanej kategorii

    @RequestMapping("/catBooks")
    public String getBookByCategory(Model model) {
        List<Book> books = bookRepository.findAllByCategory("Cat 1");
        for (Book book : books) {
            System.out.println(book.getId() + " ");
        }
        model.addAttribute("books", books);
        return "catBooks";
    }


    //    metodę wyszukującą książki dla zadanego tytułu.
    @RequestMapping("/getBooks")
    public String getBookByTitle(Model model) {
        List<Book> books = bookRepository.findAllByTitle("test4");
        for (Book book : books) {
            System.out.println(book.getId() + " ");
        }
        model.addAttribute("books", books);
        return "getBooks";
    }

    @GetMapping
    public String allBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/filter")
    public String booksByRating(@RequestParam int rating, Model model) {
        List<Book> books = bookDao.findByRating(rating);
        model.addAttribute("books", books);
        return "books";
    }


    @GetMapping("/byRating")
    @ResponseBody
    public String booksByRating() {
        List<Book> allByRating = bookRepository.findAllByRating(1, 10);

        Book allLimit1 = bookRepository.findAllLimit1();
        Book allPageable = bookRepository.findAllPageable(PageRequest.of(0, 1)).get(0);
        return String.valueOf(allByRating.size());
    }

    @GetMapping("/dtoByRating")
    @ResponseBody
    public String booksDtoByRating() {
        List<BookDto> allByRating = bookRepository.findDtoAllByRating(1, 10);
        return String.valueOf(allByRating.size());
    }

    @GetMapping("/byPublisher")
    @ResponseBody
    public String booksByPublisher() {
        List<Book> allByRating = bookRepository.findAllByPublisherName("Publisher 1");
        return String.valueOf(allByRating.size());
    }

    @GetMapping("/byCategory")
    @ResponseBody
    public String booksByCategory() {
        List<Book> allByRating = bookRepository.findAllByCategoryName("Cat 1");
        return String.valueOf(allByRating.size());
    }

    @GetMapping("/byTitle")
    @ResponseBody
    public String booksByTitle2() {
        List<Book> allByRating = bookRepository.findAllByTitle2("test4");
        return String.valueOf(allByRating.size());
    }


    @GetMapping("/addBook")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/addBook")
    public String add(@Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addBook";
        }
        bookDao.save(book);
        return "redirect:/books";
    }

    @GetMapping("/deleteById/{id}")
    public String delete(@PathVariable Long id) {
        bookDao.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/editBook/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "addBook";
    }

    @ModelAttribute("publishers")
    public List<Publisher> allPublishers() {
        return publisherDao.findAll();
    }

    @ModelAttribute("authorList")
    public List<Author> allAuthor() {
        return authorDao.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> allCategories() {
        return categoryDao.findAll();
    }
}


//@AllArgsConstructor
//@Controller
//public class BookController {
//    private final BookService bookService;
//
//    @RequestMapping(value = "/book/all")
//    @ResponseBody
//    public String allBooks() {
//        List<Book> books = bookService.findAll();
//        books.forEach(b -> System.out.println(b.toString()));
//        return "Ilość książek" + books.size();
//    }
//    @RequestMapping(value = "/book/add")
//    @ResponseBody
//    public String addBook() {
//        Book book = bookService.addBook();
//        return "Id dodanej książki to:" + book.getId();
//    }
//    @RequestMapping(value = "/book/get")
//    @ResponseBody
//    public String getBook() {
//        Book book = bookService.findById(1L);
//        return "Id dodanej książki to:" + book.getId();
//    }
//
//    @RequestMapping(value = "/book/all/{rating}")
//    @ResponseBody
//    public String allBooksByRating(@PathVariable int rating) {
//        List<Book> books = bookService.findAllByRating(rating);
//        books.forEach(b -> System.out.println(b.toString()));
//        return "Ilość książek" + books.size();
//    }
//
//    @RequestMapping(value = "/book/publisher/{id}")
//    @ResponseBody
//    public String allBooksWithPublisher(@PathVariable int id) {
//        List<Book> books = bookService.findAllWithPublisher(id);
//        books.forEach(b -> System.out.println(b.toString()));
//        return "Ilość książek mającyh wydawców : " + books.size();
//    }
//
//}


//@Controller
//public class BookController {
//    private final BookDao bookDao;
//    public BookController(BookDao bookDao) {
//        this.bookDao = bookDao;
//    }
//    @RequestMapping(value = "/book/add", produces = "text/html; charset=UTF-8")
//    @ResponseBody
//    public String hello() {
//        Book book = new Book();
//        book.setTitle("Thinking in Java");
//        book.setAuthor("Bruce Eckel");
//        bookDao.saveBook(book);
//        return "Id dodanej książki to:"
//                + book.getId();
//    }
//    @RequestMapping("/book/get/{id}")
//    @ResponseBody
//    public String getBook(@PathVariable long id) {
//        Book book = bookDao.findById(id);
//        return book.toString();
//    }
//    @RequestMapping("/book/update/{id}/{title}")
//    @ResponseBody
//    public String updateBook(@PathVariable long id, @PathVariable String title ) {
//        Book book = bookDao.findById(id);
//        book.setTitle(title);
//        bookDao.update(book);
//        return book.toString();
//    }
//    @RequestMapping("/book/delete/{id}")
//    @ResponseBody
//    public String deleteBook(@PathVariable long id) {
//        Book book = bookDao.findById(id);
//        bookDao.delete(book);
//        return "deleted";
//    }


//}
