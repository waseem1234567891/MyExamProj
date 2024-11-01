package com.example.NewExamDemoProj1.services;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import com.example.NewExamDemoProj1.entity.User;
import com.example.NewExamDemoProj1.exceptions.UserRegistrationException;
import com.example.NewExamDemoProj1.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser_UsernameExists() {
        User user = new User();
        user.setUsername("existingUser");
        user.setEmail("test@example.com");

        when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.of(user));

        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> {
            userService.registerUser(user);
        });

        assertEquals("Username already exists.", exception.getMessage());
    }

    @Test
    void testRegisterUser_EmailExists() {
        User user = new User();
        user.setUsername("newUser");
        user.setEmail("existing@example.com");

        when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.empty());
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));

        UserRegistrationException exception = assertThrows(UserRegistrationException.class, () -> {
            userService.registerUser(user);
        });

        assertEquals("Email already exists.", exception.getMessage());
    }

    @Test
    void testRegisterUser_Success() {
        User user = new User();
        user.setUsername("newUser");
        user.setEmail("new@example.com");

        when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.empty());
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        when(userRepository.save(user)).thenReturn(user);

        User registeredUser = userService.registerUser(user);
        assertEquals(user, registeredUser);
    }
}
