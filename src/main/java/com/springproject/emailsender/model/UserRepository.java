package com.springproject.emailsender.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface that extends from CrudRepository, providing the standard CRUD methods for the specified entity
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
