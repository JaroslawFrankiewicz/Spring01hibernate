package pl.coderslab.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 5)
    private String title;
//    @NotNull
//    private String author;

    @Range(min = 1, max = 10)
    private int rating;

//    @NotBlank
//    @Size(max = 600)
//    private String decription;
//    @Min(1)
//    private int pages;
    //gettery i settery

//    @NotNull
    @ManyToOne
    private Category category;

    @NotNull
    @ManyToOne
    private Publisher publisher;

    @ManyToMany

    @JoinTable(name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors = new ArrayList<>();


}
