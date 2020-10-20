package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class PersonDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private String firstName;
//    private String lastName;
//    private String streetNumber;
//    private String street;
//    private String city;
//
//    @OneToOne
//    @JoinColumn(name = "person_id")
//    private Person person;
}
