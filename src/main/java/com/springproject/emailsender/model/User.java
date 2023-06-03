package com.springproject.emailsender.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


/**
 * Application main entity.
 */

@Getter
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @MongoId
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
