package com.springproject.emailsender.controller;

import com.springproject.emailsender.model.User;
import com.springproject.emailsender.service.UserService;
import com.springproject.emailsender.service.impl.EmailServiceImpl;
import com.springproject.emailsender.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    EmailServiceImpl emailService;

    @GetMapping
    public ResponseEntity<LinkedList<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById( String username){
        return ResponseEntity.ok(userService.findById(username));
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user){
        userService.insert(user);
        emailService.sendEmail("luanorizona1@gmail.com", "Teste", "Este é um email teste");
        return ResponseEntity.ok(user);
    }

}
