package com.example.NewExamDemoProj1.services;

import com.example.NewExamDemoProj1.entity.User;
import com.example.NewExamDemoProj1.exceptions.UserRegistrationException;
import com.example.NewExamDemoProj1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;


@Service
@Validated
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(@Valid User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserRegistrationException("Username already exists.");
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserRegistrationException("Email already exists.");
        }
        return userRepository.save(user);
    }
}

