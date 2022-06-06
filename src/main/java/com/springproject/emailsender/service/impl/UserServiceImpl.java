package com.springproject.emailsender.service.impl;

import com.springproject.emailsender.model.User;
import com.springproject.emailsender.model.UserRepository;
import com.springproject.emailsender.model.exceptions.UsernameAlreadyExistsException;
import com.springproject.emailsender.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public LinkedList<User> findAll() {
        LinkedList<User> users = new LinkedList<>();
        repository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User findById(String username) {
        Optional<User> user = repository.findById(username);
        return user.orElse(null);
    }

    @Override
    public void insert(User user) {
        LinkedList<User> users = findAll();
        if (users.stream().map(User::getLogin).collect(Collectors.toList()).contains(user.getLogin()))
            throw new UsernameAlreadyExistsException("Username already exists");
        else {
            repository.save(user);
        }
    }

    @Override
    public void remove(User user) throws IllegalArgumentException {
        repository.delete(user);
    }

}

