package com.example.job_seeking.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Title cannot be empty!")
    @Size(min = 5, message = "The length must be more than 4 characters")
    @Column(columnDefinition = "varchar(10) not null")
    private String title;

    @NotEmpty(message = "Description cannot be empty!")
    @Column(columnDefinition = "varchar(20) not null")
    private String description;

    @NotEmpty(message = "Location cannot be empty!")
    @Column(columnDefinition = "varchar(20) not null")
    private String location;

@NotNull(message = "Salary cannot be null!.. ")
@Positive(message = "Salary must be Positive")
@Column(columnDefinition = "int not null default 0")
    private Integer salary;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDate postingDate;

}
