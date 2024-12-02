package com.example.job_seeking.Controller;

import com.example.job_seeking.ApiResponse.ApiResponse;
import com.example.job_seeking.Model.JobPost;
import com.example.job_seeking.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jobpost")
@RequiredArgsConstructor
public class JobPostController {
    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity getjobPost(){
        return ResponseEntity.status(200).body(jobPostService.getJobPost());
    }

    @PostMapping("/add")
    public ResponseEntity addjobPost(@RequestBody @Valid JobPost jobPost, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        jobPostService.addJobPost(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("Done Adding"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable Integer id,@RequestBody @Valid JobPost jobPost,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdate= jobPostService.updateJobPost(jobPost,id);
        if(isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse("Done Updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Cannot Found the id"));

    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity deletMerchant(@PathVariable Integer id){
        boolean isDelet= jobPostService.deletJobPost(id);
        return ResponseEntity.status(200).body(new ApiResponse("Done Deleted"));

    }
}
