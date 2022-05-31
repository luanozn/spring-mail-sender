package com.springproject.emailsender.service;

import com.springproject.emailsender.model.User;

import java.awt.*;
import java.util.LinkedList;

public interface UserService {

    Iterable<User> findAll();
    User findById(String username);
    void insert(User user);
    void update(String username, User user);
    void remove(User user);

}
