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
        emailService.sendEmail(
                user.getEmail(),
                "Confirmação de Cadastro",
                String.format("<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "<!-- HTML Codes by Quackit.com -->\n" +
                        "<title>\n" +
                        "</title>\n" +
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "<style>\n" +
                        "body {background-repeat:no-repeat;background-position:center center;background-attachment:fixed;}\n" +
                        "h2{font-family:Impact, sans-serif;font-variant:small-caps;color:#58181f;padding-bottom:20px}\n" +
                        "p {text-align:center;font-family:Arial, sans-serif;font-size:15px;font-style:italic;font-weight:bold;color:#000000}" +
                        "att {padding-top:20px}\n" +
                        "</style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<h2>Cadastro realizado com sucesso!</h2>\n" +
                        "<p>Parabéns %s, seu usuário foi cadastrado com sucesso.</p>\n" +
                        "<p id='att'>Atenciosamente</p>\n" +
                        "<p>Projeto Mail Sender</p>\n" +
                        "</body>\n" +
                        "</html>\n", user.getName()));
        return ResponseEntity.ok(user);
    }

}
