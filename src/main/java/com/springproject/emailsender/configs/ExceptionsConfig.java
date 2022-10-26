package com.springproject.emailsender.configs;

import com.springproject.emailsender.model.exceptions.UserNotFoundException;
import com.springproject.emailsender.model.exceptions.UsernameAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.NoResultException;

/**
 * Controller for the exception treatment based on the HTTP status.
 * 404 (not found)   -> to exceptions without result;
 * 400 (bad request) -> to exceptions with malformed requests.
 * Avoid error 500 (Server error)
 */

@ControllerAdvice
public class ExceptionsConfig {

    /**
     * Method that treats not found HTTP responses for specified Exceptions.
     *
     * @param e caught exception.
     * @return message error.
     */
    @ResponseBody
    @ExceptionHandler({NoResultException.class, UserNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noResultExceptionHandler(NoResultException e){
        return e.getMessage();
    }

    /**
     * Method that treats bad request HTTP responses for specified Exception.
     *
     * @param e caugh exception
     * @return message error
     */
    @ResponseBody
    @ExceptionHandler(UsernameAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String runtimeExceptionHandler(RuntimeException e){
        return e.getMessage();
    }

}
