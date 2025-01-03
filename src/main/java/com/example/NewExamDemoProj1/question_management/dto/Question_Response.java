package com.example.NewExamDemoProj1.question_management.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class Question_Response {
    private boolean success;
    private String status;
    private String message;
}
