package com.example.job_seeking.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "user id cannot be null!..")
    @Column(columnDefinition = "int not null")
    private Integer userid;
    @NotNull(message = "jobPost id cannot be null!..")
    @Column(columnDefinition = "int not null")
    private Integer jobPostId;



}
