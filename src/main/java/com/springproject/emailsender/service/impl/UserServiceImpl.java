package com.springproject.emailsender.service.impl;

import com.springproject.emailsender.model.User;
import com.springproject.emailsender.model.UserRepository;
import com.springproject.emailsender.model.exceptions.UserNotFoundException;
import com.springproject.emailsender.model.exceptions.UsernameAlreadyExistsException;
import com.springproject.emailsender.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
/**
 * Class that implements the UserService interface, providing the CRUD methods for user information
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public LinkedList<User> findAll() {
        LinkedList<User> users = new LinkedList<>();
        repository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User findById(String username) {
        return repository.findById(username).orElseThrow(() -> new UserNotFoundException(username));
    }

    @Override
    public void insert(User user) {
        if(repository.existsById(user.getLogin()))
            throw new UsernameAlreadyExistsException(user.getLogin());
        repository.save(user);
    }

    @Override
    public void remove(User user){
        if(repository.existsById(user.getLogin()))
            repository.delete(user);
        else
            throw new UserNotFoundException(user.getLogin());
    }

    @Override
    public void update(String username, User user){
        if(findById(username).getLogin().equals(user.getLogin()))
            repository.save(user);
    }

    public List<String> getInfo(User user){
        return Arrays.asList(user.getLogin(),
                user.getPassword(),
                user.getName(),
                user.getEmail());
    }
}

