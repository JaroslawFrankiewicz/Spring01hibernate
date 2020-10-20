package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Author;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Book;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }
    @GetMapping("/authors")
    public String allBooks(Model model) {
        List<Author> authors = authorDao.findAll();
        model.addAttribute("authors", authors);
        return "authors";
    }
    @GetMapping("/addAuthor")
    public String addAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "addAuthor";
    }
    @PostMapping("/addAuthor")
    public String add(@Valid Author author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addAuthor";
        }
        authorDao.createAuthor(author);
        return "redirect:/authors";
    }
    @RequestMapping("/author/add")
    @ResponseBody
    public String hello() {
        Author author = new Author();
        author.setFirstName("Bruce");
        author.setLastName("Lee");
        authorDao.createAuthor(author);
        return "Id dodanego autora to:"
                + author.getId();
    }
    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id) {
        Author author = authorDao.readAuthor(id);
        return author.toString();
    }
    @RequestMapping("/author/update/{id}/{title}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id, @PathVariable String firstName ) {
        Author author = authorDao.readAuthor(id);
        author.setFirstName(firstName);
        authorDao.updateAuthor(author);
        return author.toString();
    }
    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable long id) {
        Author author = authorDao.readAuthor(id);
        authorDao.deleteAuthor(author);
        return "deleted";
    }
    @RequestMapping(value = "/author/all")
    @ResponseBody
    public String allAuthor() {
        List<Author> authors = authorDao.findAll();
        authors.forEach(a -> System.out.println(a.toString()));
        return "Ilość autorów" + authors.size();
    }


    @RequestMapping("/author/all/{id}")
    @ResponseBody
    public List<Author> findAll() {
        return authorDao.findAll();
    }

}
