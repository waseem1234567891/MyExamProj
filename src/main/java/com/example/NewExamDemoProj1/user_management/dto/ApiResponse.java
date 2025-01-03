package com.example.NewExamDemoProj1.user_management.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    boolean success;
    private String status;
    private String message;
}
