package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.model.Person;
import pl.coderslab.model.Publisher;

@AllArgsConstructor
@Controller
public class PersonController {
    private final PersonDao personDao;


    @RequestMapping(value = "/person/form")
    public String getPersonForm(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "personForm";
    }

    @RequestMapping(value = "/person/form", method = RequestMethod.POST)
    @ResponseBody
    public String postPerson(@ModelAttribute Person person) {
        personDao.save(person);
        return person.toString();
    }



}
