package pl.coderslab.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookDto;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

//    List<Book> findAllByTitleAndAndRating

//    metodę wyszukującą książki dla zadanego tytułu.
    List<Book> findAllByTitle(String title);

//    metodę wyszukującą książki dla zadanej kategorii
    List<Book> findAllByCategory(String name);


    // zad 1 dzień 2
    @Query("SELECT b FROM Book b where b.rating between ?1 and ?2")
    List<Book> findAllByRating(int min, int max);

    @Query("SELECT b FROM Book b where b.title like ?1")
    List<Book> findAllByTitle2(String title);

    @Query("SELECT b FROM Book b where b.publisher.name like :publisherName")
    List<Book> findAllByPublisherName(@Param("publisherName") String publisherName);

    @Query("SELECT b FROM Book b where b.category.name like :categoryName")
    List<Book> findAllByCategoryName(@Param("categoryName") String categoryName);

    List<Book> findAllByTitleContains(String title);

    @Query(value = "SELECT * FROM Book b LIMit 1", nativeQuery = true)
    Book findAllLimit1();

    @Query("SELECT b FROM Book b order by b.title")
    List<Book> findAllPageable(Pageable pageable);



//  DTO
    @Query("SELECT new pl.coderslab.model.BookDto(b.title) FROM Book b where b.rating between ?1 and ?2")
    List<BookDto> findDtoAllByRating(int min, int max);
}
