package com.example.job_seeking.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
//@Check(constraints = "LENGTH(name) > 4 AND name ~ '^[a-zA-Z]+$'")
//@Check(constraints = "email ~ '^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$'")
//@Check(constraints = "LENGTH(password) >= 8 AND LENGTH(password) <= 20 AND password REGEXP '^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,20}$'")
//@Check(constraints = "role IN ('JOB_SEEKER', 'EMPLOYER')")
@Table(name = "myUser")
public class User_u {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name cannot be empty!")
    @Size(min = 5, message = "The length must be more than 4 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only characters!")
    @Column(columnDefinition = "varchar(10) not null")
    private String name;

    @NotEmpty(message = "email cannot be Empty!..")
    @Email(message = "Must be a valid email format")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    //@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,20}$", message = "Password must be between 8 to 20 characters, include letters, numbers, and at least one special character.")
    @NotEmpty(message = "password cannot be Empty!..")
    @Column(columnDefinition = "varchar(10) not null")
    private String password;

    @NotNull(message = " age cannot be null")
    @Min(value = 21,message = " age must be more than 21")
    @Column(columnDefinition = "int not null default 21")
    private Integer age;

    @NotEmpty(message = "Role cannot be Empty!..")
    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)$",message = "the role must be \"JOB_SEEKER\" or \"EMPLOYER\"")
    @Column(columnDefinition = "varchar(10) not null")
    private String role;
}
