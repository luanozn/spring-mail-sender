package com.springproject.emailsender.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    /*
        Interface que extende de CrudRepository, outra interface do banco de dados
        que provê implementações já prontas de armazenamento, atualização, remoção
        e requisição de objetos.
     */
}
