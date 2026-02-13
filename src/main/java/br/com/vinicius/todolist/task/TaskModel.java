package br.com.vinicius.todolist.task;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

/*
 * Estrutura:
 * ID
 * Usuario
 * Descrição
 * Titulo
 * Prioridade
 * Data de inicio
 * Data de conclusão
 * Data de criação
 */

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    // UUID
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private UUID idUser;

    // Dados da Task // Titulo limitado a 50 caracteres
    private String description;
    @Column(length = 50)
    private String title;
    private String priority;

    // Data de Inicio e Conclusão
    private LocalDateTime startAt;
    private LocalDateTime endAt;

    // Data Criado
    @CreationTimestamp
    private LocalDateTime createdAt;

    public void setTitle(String title) throws Exception{
        if(title.length() > 50) {
            throw new Exception("O campo title deve conter no maximo 50 caracteres.");
        }
        this.title = title;
    }
}
