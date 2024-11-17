package com.example.NewExamDemoProj1.services;

import com.example.NewExamDemoProj1.adminManagement.dto.AdminLoginRequest;
import com.example.NewExamDemoProj1.adminManagement.entity.AdminUser;
import com.example.NewExamDemoProj1.repository.AdminRepository;
import com.example.NewExamDemoProj1.user_management.exceptions.InvalidPasswordException;
import com.example.NewExamDemoProj1.user_management.exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public AdminUser login_admin(@Valid AdminLoginRequest adminLoginRequest)
    {
        Optional<AdminUser> optionalAdminUser=adminRepository.findByEmail(adminLoginRequest.getEmail());
        if(optionalAdminUser.isPresent())
        {
            AdminUser adminUser=optionalAdminUser.get();
            if(adminUser.getPassword().equals(adminLoginRequest.getPassword()))
            {
                return adminUser;
            }else {
                throw new InvalidPasswordException("Password is InCorrect");
            }
        }else {
            throw new UserNotFoundException("User does not exist");
        }
    }
}
