package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Publisher;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PublisherController {
    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }
    //dodac i poprawić plik jsp dla Publishera
    @GetMapping("/publishers")
    public String allBooks(Model model) {
        List<Publisher> publishers = publisherDao.findAll();
        model.addAttribute("publishers", publishers);
        return "publishers";
    }
    @GetMapping("/addPublisher")
    public String addAuthorForm(Model model) {
        model.addAttribute("publishers", new Publisher());
        return "addPublisher";
    }
    @PostMapping("/addPublisher")
    public String add(@Valid Publisher publisher, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addPublisher";
        }
        publisherDao.createPublisher(publisher);
        return "redirect:/publishers";
    }
    @RequestMapping("/publisher/add")
    @ResponseBody
    public String hello() {
        Publisher publisher = new Publisher();
        publisher.setName("Świat książki");
        publisherDao.createPublisher(publisher);
        return "Id dodanego wydawcy to:"
                + publisher.getId();
    }

    @RequestMapping("/publisher/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.readPublisher(id);
        return publisher.toString();
    }

    @RequestMapping(value = "/publisher/all")
    @ResponseBody
    public String allPublisher() {
        List<Publisher> publishers = publisherDao.findAll();
        publishers.forEach(p -> System.out.println(p.toString()));
        return "Ilość wydawców : " + publishers.size();
    }


    @RequestMapping(value = "/publisher/all/{id}")
    @ResponseBody
    public List<Publisher> findAll() {
        return publisherDao.findAll();
    }



//    @RequestMapping("/publisher/update/{id}/{title}")
//    @ResponseBody
//    public String updatePublisher(@PathVariable long id, @PathVariable String name) {
//        Publisher publisher = publisherDao.readPublisher(id);
//        publisher.setName(name);
//        publisher.up(publisher);
//        return publisher.toString();
//    }
//
//    @RequestMapping("/publisher/delete/{id}")
//    @ResponseBody
//    public String deletePublisher(@PathVariable long id) {
//        Publisher publisher = publisherDao.readPublisher(id);
//        publisher.d(publisher);
//        return "deleted";
//    }
}
