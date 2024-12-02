package com.example.job_seeking.Controller;

import com.example.job_seeking.ApiResponse.ApiResponse;
import com.example.job_seeking.Model.JobApplication;
import com.example.job_seeking.Model.JobPost;
import com.example.job_seeking.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jobApp")
@RequiredArgsConstructor
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;


    @GetMapping("/get")
    public ResponseEntity getjobApp(){
        return ResponseEntity.status(200).body(jobApplicationService.getJobApplication());
    }


    @PostMapping("/add")
    public ResponseEntity addjobApp(@RequestBody @Valid JobApplication jobApplication, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        String result=jobApplicationService.addJobApplication(jobApplication);
        return ResponseEntity.status(200).body(result);
    }



    @DeleteMapping("/delet/{id}")
    public ResponseEntity deletjobApp(@PathVariable Integer id){
        boolean isDelet= jobApplicationService.deletJobApplication(id);
        return ResponseEntity.status(200).body(new ApiResponse("Done Deleted"));

    }
}
