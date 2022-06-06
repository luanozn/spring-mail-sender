package com.springproject.emailsender.configs;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.NoResultException;

@ControllerAdvice
public class ExceptionsConfig {

    /*
        Classe que configura o tratamento de exceções com base nos status HTTP
        neste caso, utiliza-se 404 (not found) para exceções sem resultado
        e 400 (bad request) para outras exceções (Username já existe)

        Ela é utilizada para evitar que sempre ocorra o erro 500 (Server error)
     */

    @ResponseBody
    @ExceptionHandler(NoResultException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noResultExceptionHandler(NoResultException e){
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String runtimeExceptionHandler(RuntimeException e){
        return e.getMessage();
    }

}
