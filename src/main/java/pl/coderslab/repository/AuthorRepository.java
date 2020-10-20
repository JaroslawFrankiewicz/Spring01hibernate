package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.model.Author;

import java.util.List;


public interface AuthorRepository extends JpaRepository<Author, Long> {

//  Listę autorów, których email zaczyna się od wskazanego ciągu znaków.

//    @Query("SELECT a FROM Author WHERE a.email")
//    List<Author> findAllBy


}
