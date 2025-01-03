package com.example.NewExamDemoProj1.adminManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminLoginRequest {

    @NotBlank(message = "User cannot be empty")
    private String userName;

    @NotBlank(message = "Password cannot be empty")
    private String password;


}
