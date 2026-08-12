package br.com.nttdata.java.desafio.tarefas.repository;

import br.com.nttdata.java.desafio.tarefas.entity.SubTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SubTaskRepository extends JpaRepository<SubTaskEntity, UUID> {

    List<SubTaskEntity> findByTaskId(UUID taskId);


}
