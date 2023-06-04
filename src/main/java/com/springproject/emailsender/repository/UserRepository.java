package com.springproject.emailsender.repository;

import com.springproject.emailsender.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface that extends from CrudRepository, providing the standard CRUD methods for the specified entity
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{ 'login': ?0 }")
    Optional<User> findByRegistration(String registration);

}
