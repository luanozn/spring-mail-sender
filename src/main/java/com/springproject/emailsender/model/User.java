package com.springproject.emailsender.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @NotNull
    private String login;
    private String password;
    private String name;
    private String email;

    public User( String name, String login, String password, String email){
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
    }



    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
