package com.example.job_seeking.Repository;


import com.example.job_seeking.Model.User_u;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User_u,Integer> {
}
