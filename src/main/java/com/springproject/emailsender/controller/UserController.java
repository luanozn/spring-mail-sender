package com.springproject.emailsender.controller;

import com.springproject.emailsender.model.User;
import com.springproject.emailsender.service.UserService;
import com.springproject.emailsender.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<LinkedList<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

}
