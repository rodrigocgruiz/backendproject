package br.com.nttdata.java.desafio.tarefas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class SubTaskEntity {

    private long id;
    private String title;
    private String description;
    private boolean status;
    private LocalDate createdAt;
    private LocalDate completedAt;

    @ManyToOne
    private TaskEntity task;

}
