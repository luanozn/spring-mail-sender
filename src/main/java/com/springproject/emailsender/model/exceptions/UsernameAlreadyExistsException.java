package com.springproject.emailsender.model.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{

    public UsernameAlreadyExistsException(String username){     super(username + " already exists");    }
}
