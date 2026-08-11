package br.com.nttdata.java.desafio.tarefas.entity;

import br.com.nttdata.java.desafio.tarefas.enums.TaskStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy = "task")
    private List<SubTaskEntity> subTasks;
}
