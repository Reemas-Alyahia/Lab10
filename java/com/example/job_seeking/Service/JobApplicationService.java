package com.example.job_seeking.Service;

import com.example.job_seeking.Model.JobApplication;
import com.example.job_seeking.Model.JobPost;
import com.example.job_seeking.Model.User_u;
import com.example.job_seeking.Repository.JobApplicationRepository;
import com.example.job_seeking.Repository.JobPostRepository;
import com.example.job_seeking.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepository;
    private final JobPostRepository jobPostRepository;

    public List<JobApplication> getJobApplication(){
        return jobApplicationRepository.findAll();
    }

    /// apply
    public String addJobApplication(JobApplication jobApplication) {
        User_u user = userRepository.getById(jobApplication.getUserid());
        if (user == null || !user.getRole().equalsIgnoreCase("JOB_SEEKER")) {
            return "User not found or is not a JOB_SEEKER.";
        }

        JobPost jobPost = jobPostRepository.getById(jobApplication.getJobPostId());
        if (jobPost == null) {
            return "Job post not found.";
        }

        jobApplicationRepository.save(jobApplication);

        return "Job application has been  Applied successfully";
    }

    /// ///////

    public Boolean deletJobApplication(Integer id){
        JobApplication jobApplication=jobApplicationRepository.getById(id);
        if(jobApplication==null){
            return false;
        }
        jobApplicationRepository.delete(jobApplication);
        return true;
    }

    /// Update
    /// /public Boolean updateJobapplication(JobApplication jobApplication,Integer id){
    ///         JobApplication oldJobApplication = jobApplicationRepository.getById(id);
    ///         if (oldJobApplication == null) {
    ///             return false;
    ///         }
    ///         User_u user = userRepository.findById(jobApplication.getUserid()).orElse(null);
    ///         if (user == null || !user.getRole().equalsIgnoreCase("JOB_SEEKER")) {
    ///             return false;
    ///         }
    ///
    ///         JobPost jobPost = jobPostRepository.findById(jobApplication.getJobPostId()).orElse(null);
    ///         if (jobPost == null) {
    ///             return false;
    ///         }
    ///
    ///         oldJobApplication.setUserid(jobApplication.getUserid());
    ///         oldJobApplication.setJobPostId(jobApplication.getJobPostId());
    ///
    ///         jobApplicationRepository.save(oldJobApplication);
    ///
    ///         return true;
    ///     }
}
