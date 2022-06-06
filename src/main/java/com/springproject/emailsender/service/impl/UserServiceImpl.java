package com.springproject.emailsender.service.impl;

import com.springproject.emailsender.model.User;
import com.springproject.emailsender.model.UserRepository;
import com.springproject.emailsender.model.exceptions.UpdateException;
import com.springproject.emailsender.model.exceptions.UsernameAlreadyExistsException;
import com.springproject.emailsender.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    /*
    * Classe que implementa a interface UserService, realizando os métodos de busca, inserção e remoção
    * que podem ser utilizados onde houver a injeção de dependência por parte do Spring (Autowired)
    * */

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

    @Override
    public void update(String username, User user){
        LinkedList<User> users = findAll();
        if(
            users.stream().map(User::getLogin).collect(Collectors.toList()).contains(username) &&
            user.getLogin().equals(username)
        )
            repository.save(user);
        else
            throw new UpdateException("Can't update an nonexistent user.");
    }

    public List<String> getInfo(User user){
        return Arrays.asList(user.getLogin(),
                user.getPassword(),
                user.getName(),
                user.getEmail());
    }
}

