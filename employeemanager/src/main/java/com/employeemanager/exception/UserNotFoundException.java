package com.employeemanager.exception;

//The UserNotFoundException is a custom runtime exception that is thrown when a user is not found.

public class UserNotFoundException extends RuntimeException {
   
	// Constructs a new UserNotFoundException with the specified message.
     
    public UserNotFoundException(String message) {
        super(message);
    }
}