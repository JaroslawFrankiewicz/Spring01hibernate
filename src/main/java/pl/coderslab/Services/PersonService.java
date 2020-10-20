package pl.coderslab.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.model.Book;
import pl.coderslab.model.Person;


import javax.transaction.Transactional;

@Transactional
@AllArgsConstructor
@Service
public class PersonService {
    private final PersonDao personDao;

//    public Person addPerson() {
//        Person person = new Person();
//        person.setLogin("Jan");
////        person.setEmail("jan@wp.pl");
//        Person persistedPerson = personDao.createPerson(person);
//    return person;
//    }
}
