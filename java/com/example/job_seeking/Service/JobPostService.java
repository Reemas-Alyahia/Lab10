package com.example.job_seeking.Service;

import com.example.job_seeking.Model.JobApplication;
import com.example.job_seeking.Model.JobPost;
import com.example.job_seeking.Repository.JobPostRepository;
import com.example.job_seeking.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {
    private final JobPostRepository jobPostRepository;

    public List<JobPost> getJobPost(){
        return jobPostRepository.findAll();
    }
    public void addJobPost(JobPost jobPost){
        jobPostRepository.save(jobPost);
    }

    public Boolean updateJobPost(JobPost jobPost,Integer id){
        JobPost oldjop=jobPostRepository.getById(id);
        if(oldjop==null){
            return false;
        }
  oldjop.setPostingDate(jobPost.getPostingDate());
        oldjop.setTitle(jobPost.getTitle());
        oldjop.setLocation(jobPost.getLocation());
        oldjop.setDescription(jobPost.getDescription());
oldjop.setSalary(jobPost.getSalary());
        jobPostRepository.save(oldjop);

        return true;
    }

    public Boolean deletJobPost(Integer id){
        JobPost jobPost=jobPostRepository.getById(id);
        if(jobPost==null){
            return false;
        }

        jobPostRepository.delete(jobPost);
        return true;
    }


}
