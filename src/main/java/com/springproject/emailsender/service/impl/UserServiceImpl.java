package com.springproject.emailsender.service.impl;

import com.springproject.emailsender.model.User;
import com.springproject.emailsender.repository.UserRepository;
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
 * and creating custom actions
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Method that retrieve all users in database.
     *
     * @return LinkedList containing all users on database.
     */
    @Override
    public LinkedList<User> findAll() {
        return new LinkedList<>(repository.findAll());
    }

    /**
     * Method that find one specific user on database by its identifier.
     *
     * @param username user identifier.
     * @return specific user retrieved from identifier.
     */
    @Override
    public User findById(String username) {
        return repository.findById(username).orElseThrow(() -> new UserNotFoundException(username));
    }

    /**
     * Method that inserts a new user into database
     *
     * @param user the user who will be added on database.
     */
    @Override
    public void insert(User user) {
        if(repository.existsById(user.getLogin()))
            throw new UsernameAlreadyExistsException(user.getLogin());
        repository.save(user);
    }

    /**
     * Method that will remove one user from database
     *
     * @param user the user who will be removed from database.
     */
    @Override
    public void remove(User user){
        if(repository.existsById(user.getLogin()))
            repository.delete(user);
        else
            throw new UserNotFoundException(user.getLogin());
    }

    /**
     * Method that will update user data on database
     *
     * @param username User identifier that retrieve before update.
     * @param user User that contains a user with new information but same username.
     */
    @Override
    public void update(String username, User user){
        if(findById(username).getLogin().equals(user.getLogin()))
            repository.save(user);
    }

}

