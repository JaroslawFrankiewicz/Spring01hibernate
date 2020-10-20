package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Person;
import pl.coderslab.model.Student;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Controller
public class StudentController {
    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("a", "b", "c", "d", "e");
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("Java", "Perl", "Ruby", "C++", "Python");
    }

    @RequestMapping(value = "/student/form")
    public String getPersonForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "studentForm";
    }
    @RequestMapping(value = "/student/form", method = RequestMethod.POST)
    @ResponseBody
    public String postStudent(@ModelAttribute Student student) {
        System.out.println(student);
        return student.toString();
    }

}
