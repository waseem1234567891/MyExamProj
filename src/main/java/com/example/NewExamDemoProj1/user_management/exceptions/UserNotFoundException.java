package com.example.NewExamDemoProj1.user_management.exceptions;

public class UserNotFoundException extends RuntimeException{
public UserNotFoundException(String message)
{
    super(message);
}
}
