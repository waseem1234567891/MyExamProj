package com.example.NewExamDemoProj1.user_management.services.exceptions;

public class InvalidPasswordException extends RuntimeException{

    public InvalidPasswordException(String message)
    {
        super(message);
    }
}
