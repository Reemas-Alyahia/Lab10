package com.example.job_seeking.Controller;


import com.example.job_seeking.ApiResponse.ApiResponse;
import com.example.job_seeking.Model.User_u;
import com.example.job_seeking.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body(userService.getUser());
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@RequestBody @Valid User_u user , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("Done Adding"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable Integer id,@RequestBody @Valid User_u user_u,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdate= userService.updateUser(user_u,id);
        if(isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse("Done Updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Cannot Found the id"));

    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity deletMerchant(@PathVariable Integer id){
        boolean isDelet= userService.deletUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("Done Deleted"));

    }
}
