package com.example.job_seeking.Service;


import com.example.job_seeking.Model.User_u;
import com.example.job_seeking.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository  userRepository;
    public List<User_u> getUser(){
        return userRepository.findAll();
    }
    public void addUser(User_u user){
        userRepository.save(user);
    }

    public Boolean updateUser(User_u user,Integer id){
        User_u olduser=userRepository.getById(id);
        if(olduser==null){
            return false;
        }
       olduser.setName(user.getName());
        olduser.setAge(user.getAge());
        olduser.setEmail(user.getEmail());
        olduser.setPassword(user.getPassword());
        olduser.setRole(user.getRole());

        userRepository.save(olduser);

        return true;
    }

    public Boolean deletUser(Integer id){
        User_u user=userRepository.getById(id);
        if(user==null){
            return false;
        }

        userRepository.delete(user);
        return true;
    }


}
