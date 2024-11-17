package com.example.NewExamDemoProj1.controllers;

import com.example.NewExamDemoProj1.user_management.dto.ApiResponse;
import com.example.NewExamDemoProj1.user_management.dto.ChangePasswordRequest;
import com.example.NewExamDemoProj1.user_management.dto.LoginRequest;
import com.example.NewExamDemoProj1.user_management.dto.UserRegistrationRequest;
import com.example.NewExamDemoProj1.user_management.entity.User;
import com.example.NewExamDemoProj1.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers()
    {
      return   userService.getAllRegisterUsers();
    }
    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody UserRegistrationRequest userRegistrationRequest, @RequestHeader Map<String,String> header) {
        System.out.println(header);
        
        User registeredUser = userService.registerUser(userRegistrationRequest);
        ApiResponse response = new ApiResponse("success", "User Registered Successfully!");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginUser(@Valid @RequestBody LoginRequest loginRequest)
    {
     User user=userService.login(loginRequest);
        System.out.println("hello");
        ApiResponse response = new ApiResponse("success", "User Successfully logged in!");
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @PutMapping("/updatepassword")

    public ResponseEntity<ApiResponse> changeUserPassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest)
    {

        userService.updatePassword(changePasswordRequest);
        ApiResponse response=new ApiResponse("success","Password is updated");
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

}


