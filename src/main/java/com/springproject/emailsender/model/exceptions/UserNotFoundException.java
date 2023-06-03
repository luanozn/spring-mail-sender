package com.springproject.emailsender.model.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String username){
        super(username + " not found.");
    }
}
