package com.springproject.emailsender.controller;

import com.springproject.emailsender.configs.MessageConfig;
import com.springproject.emailsender.model.User;
import com.springproject.emailsender.service.impl.EmailServiceImpl;
import com.springproject.emailsender.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Class that receives the requests and provides the adequate response for User CRUD actions
 */

@RestController
@RequestMapping("users")
public class UserController {


    private final UserServiceImpl userService;

    private final EmailServiceImpl emailService;

    @Autowired
    public UserController(UserServiceImpl userService, EmailServiceImpl emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    /**
     * Endpoint that receives the request to find all users in database.
     *
     * @return a response containing a LinkedList with all users in database, and HTTP response code.
     */

    @GetMapping
    public ResponseEntity<LinkedList<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    /**
     * Endpoint that receives the request to find only one user by Username
     *
     * @param username refers to User identifier.
     * @return a response containing a specific user, and HTTP response code.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String username){
        return ResponseEntity.ok(userService.findById(username));
    }

    /**
     * Endpoint that receives the request to insert a new User on database
     *
     * @param user refers to the user that will be inserted on database
     * @return a response containing the user that was inserted on database and the HTTP response.
     */
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user){
        userService.insert(user);
        emailService.sendEmail(user.getEmail(),"Confirmação de Cadastro", MessageConfig.getRegisterMessage(user));
        return ResponseEntity.ok(user);
    }

    /**
     * Endpoint that receives a request to delete a user from database.
     *
     * @param username refers to the user that will be removed from database.
     * @return the HTTP response according to response status.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<User> remove(@PathVariable("id") String username){
        var user = userService.findById(username);
        userService.remove(user);
        emailService.sendEmail(user.getEmail(), "Remoção de Cadastro", MessageConfig.getDeleteMessage(user.getName()));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable String id, User user) {
        userService.update(id, user);

        return ResponseEntity.ok().build();
    }
    

}
