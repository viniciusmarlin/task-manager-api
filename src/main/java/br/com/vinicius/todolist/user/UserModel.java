package br.com.vinicius.todolist.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tb_users")
public class UserModel {

    // UUID
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    // Dados do Usuario // Column Unica
    @Column(unique = true)
    private String username;
    private String name;
    private String password;

    // Data Criado
    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
