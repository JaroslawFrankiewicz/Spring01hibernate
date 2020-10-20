package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Controller
public class ValidationController {

    @Autowired
    private Validator validator;


    @GetMapping("/validate")
    public String addBookForm(Model model) {
        Book b1 =  new Book();
//        Author a1 = new Author();
//        Publisher p1 = new Publisher();
        List<String> validate = new ArrayList<>();
        Set<ConstraintViolation<Book>> violations = validator.validate(b1);
//        Set<ConstraintViolation<Author>> violations1 = validator.validate(a1);
//        Set<ConstraintViolation<Publisher>> violations2 = validator.validate(p1);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage());
                validate.add(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage());
            }
        } else {
            // save object
        }

        model.addAttribute("validate", validate);
        return "validate";
    }


}