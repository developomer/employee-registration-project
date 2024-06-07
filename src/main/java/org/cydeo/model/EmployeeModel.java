package org.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;

//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class EmployeeModel {

    //  @NotNull      ----> Field shouldn't be null
    //  @NotEmpty     ----> Field shouldn't be ""
    //  @NotBlank     ----> Field shouldn't be "  "

    //  @NotNull  -> @NotNull
    //  @NotEmpty -> @NotEmpty
    //  @NotBlank -> @NotBlank


    @NotBlank
    @Size(min = 2, max = 12)
    private String firstName;

    private String lastName;

//    @NotBlank
//    @Email
    private String email;

//    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

//    @NotBlank
//    @Pattern(regexp = "(?=.*\\d) (?=.*[a-z]) (?=.*[A-Z]) .{4,}")
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;

    public int getAge() {
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }


}
