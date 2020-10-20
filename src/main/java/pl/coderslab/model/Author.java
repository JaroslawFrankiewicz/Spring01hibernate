package pl.coderslab.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @PESEL
    private String pesel;
    @Email
    private String email;


    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();

}