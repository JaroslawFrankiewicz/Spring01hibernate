package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Student {
    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private String notes;
    boolean mailingList;
    List programmingSkills;
    List hobbies;


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", notes='" + notes + '\'' +
                ", mailingList=" + mailingList +
                ", programmingSkills=" + programmingSkills +
                ", hobbies=" + hobbies +
                '}';
    }
}
