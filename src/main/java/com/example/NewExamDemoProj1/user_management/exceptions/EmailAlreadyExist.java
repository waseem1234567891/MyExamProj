package com.example.NewExamDemoProj1.user_management.exceptions;

public class EmailAlreadyExist extends RuntimeException {
    public EmailAlreadyExist(String message) {
        super(message);
    }
}