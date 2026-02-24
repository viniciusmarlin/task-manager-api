package br.com.vinicius.todolist.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {
    // Buscar task por IdUser
    List<TaskModel> findByIdUser(UUID idUser);
}
