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

    @GetMapping
    public ResponseEntity<LinkedList<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String username){
        return ResponseEntity.ok(userService.findById(username));
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user){
        userService.insert(user);
        emailService.sendEmail(user.getEmail(),"Confirmação de Cadastro", MessageConfig.getRegisterMessage(user));
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> remove(@PathVariable("id") String username){
        User user = userService.findById(username);
        userService.remove(user);
        emailService.sendEmail(user.getEmail(), "Remoção de Cadastro", MessageConfig.getDeleteMessage(user));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable("id") String username, @RequestBody User user){
        List<String> information = userService.getInfo(userService.findById(username));
        userService.update(username, user);
        emailService.sendEmail(user.getEmail(), "Atualização de Cadastro", MessageConfig.getUpdateMessage(username, user, information));
        return ResponseEntity.ok(user);
    }

}
