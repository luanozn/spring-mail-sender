package com.springproject.emailsender.model.exceptions;

import javax.persistence.NoResultException;

public class UserNotFoundException extends NoResultException {

    public UserNotFoundException(String username){
        super(username + " not found.");
    }
}
