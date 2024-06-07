package org.cydeo.model;

import lombok.*;

import java.time.LocalDate;

//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Employee {

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthday;
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;

}
