package com.example.NewExamDemoProj1.user_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRequest {

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "password is required")
    @Size(min = 8,max = 16,message = "size should be from 8 to 16")
    @Pattern(regexp = ".*[!@#$%^&*()_+{}|:<>?].*",message = "Password contain at least 1 special character")
    @Pattern(regexp = ".*[0-9].*",message = "Password must contain a number")
    private String password;
}
