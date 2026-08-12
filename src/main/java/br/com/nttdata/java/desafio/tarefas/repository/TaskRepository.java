package br.com.nttdata.java.desafio.tarefas.repository;

import br.com.nttdata.java.desafio.tarefas.entity.TaskEntity;
import br.com.nttdata.java.desafio.tarefas.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {

    List<TaskEntity> findByStatus(TaskStatus status);


}
