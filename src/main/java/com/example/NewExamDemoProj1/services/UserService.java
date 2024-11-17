package com.example.NewExamDemoProj1.services;

import com.example.NewExamDemoProj1.user_management.dto.ChangePasswordRequest;
import com.example.NewExamDemoProj1.user_management.dto.LoginRequest;
import com.example.NewExamDemoProj1.user_management.dto.UserRegistrationRequest;
import com.example.NewExamDemoProj1.user_management.entity.User;
import com.example.NewExamDemoProj1.user_management.exceptions.InvalidPasswordException;
import com.example.NewExamDemoProj1.user_management.exceptions.UserNotFoundException;
import com.example.NewExamDemoProj1.user_management.exceptions.EmailAlreadyExist;
import com.example.NewExamDemoProj1.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import java.util.List;
import java.util.Optional;


@Service
@Validated
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public  User login(@Valid LoginRequest loginRequest) {
        Optional<User> optionalUser=userRepository.findByEmail(loginRequest.getEmail());
        if (optionalUser.isPresent())
        {
            User user=optionalUser.get();
            if (user.getPassword().equals(loginRequest.getPassword()))
            {
               return user;
            }else {
             throw new InvalidPasswordException("Password is not correct");
            }
        }else {
throw new UserNotFoundException("User not Found");
        }
    }

    public User registerUser(@Valid UserRegistrationRequest userRegistrationRequest) {

        if (userRepository.findByEmail(userRegistrationRequest.getEmail()).isPresent()) {
            throw new EmailAlreadyExist("Email already exists.");
        }
        User user=new User();
        user.setFirstName(userRegistrationRequest.getFirstName());
        user.setLastName(userRegistrationRequest.getLastName());
        user.setEmail(userRegistrationRequest.getEmail());
        user.setPassword(userRegistrationRequest.getPassword());
        return userRepository.save(user);
    }

    public User updatePassword(@Valid ChangePasswordRequest user) {

        Optional<User> byEmail = userRepository.findByEmail(user.getEmail());
        User user1 = byEmail.get();
        user1.setPassword(user.getPassword());

        return userRepository.save(user1);

    }

    public List<User> getAllRegisterUsers() {
        List<User> all = userRepository.findAll();
        return all;
    }
}

