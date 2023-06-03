package com.springproject.emailsender.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Application main entity.
 */

@Getter
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @Id
    @NotNull
    @EqualsAndHashCode.Include
    private String login;

    @EqualsAndHashCode.Exclude
    private String password;

    @EqualsAndHashCode.Exclude
    private String name;

    @EqualsAndHashCode.Exclude
    private String email;

    private String phone;

}
