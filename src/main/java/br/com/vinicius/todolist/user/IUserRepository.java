package br.com.vinicius.todolist.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<UserModel, UUID> {

    // Buscar usuario por nome
    UserModel findByUsername(String username);
}
