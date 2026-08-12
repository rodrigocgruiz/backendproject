package br.com.nttdata.java.desafio.tarefas.service;

import br.com.nttdata.java.desafio.tarefas.dto.request.CreateSubTaskRequestDto;
import br.com.nttdata.java.desafio.tarefas.dto.request.UpdateTaskStatusRequestDto;
import br.com.nttdata.java.desafio.tarefas.dto.response.SubTaskResponseDto;
import br.com.nttdata.java.desafio.tarefas.entity.SubTaskEntity;
import br.com.nttdata.java.desafio.tarefas.entity.TaskEntity;
import br.com.nttdata.java.desafio.tarefas.enums.TaskStatus;
import br.com.nttdata.java.desafio.tarefas.mapper.SubTaskMapper;
import br.com.nttdata.java.desafio.tarefas.repository.SubTaskRepository;
import br.com.nttdata.java.desafio.tarefas.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class SubTaskService {

    private final SubTaskRepository subTaskRepository;
    private final TaskRepository taskRepository;

    public SubTaskService(
            SubTaskRepository subTaskRepository,
            TaskRepository taskRepository) {
        this.subTaskRepository = subTaskRepository;
        this.taskRepository = taskRepository;
    }

    public SubTaskResponseDto createSubTask(
            CreateSubTaskRequestDto createSubTaskRequestDto) {

        TaskEntity taskEntity = taskRepository
                .findById(createSubTaskRequestDto.getTaskId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Task not found"));

        SubTaskEntity subTaskEntity = SubTaskMapper.toSubTaskEntity(
                createSubTaskRequestDto, taskEntity);

        subTaskEntity.setStatus(TaskStatus.PENDING);
        subTaskEntity.setCreatedAt(LocalDateTime.now());

        SubTaskEntity savedSubTask = subTaskRepository.save(subTaskEntity);
        return SubTaskMapper.toSubTaskResponseDto(savedSubTask);
    }

    public SubTaskResponseDto findById(UUID id) {
        SubTaskEntity subTaskEntity = subTaskRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("SubTask not found"));
        return SubTaskMapper.toSubTaskResponseDto(subTaskEntity);
    }

    public List<SubTaskResponseDto> findByTaskId(UUID taskId){
        return subTaskRepository.findByTaskId(taskId)
                .stream()
                .map(SubTaskMapper::toSubTaskResponseDto)
                .toList();
    }

    public SubTaskResponseDto updateStatus(
            UUID id, UpdateTaskStatusRequestDto updateSubTaskStatusRequestDto) {

        SubTaskEntity subTaskEntity = subTaskRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("SubTask not found"));

        subTaskEntity.setStatus(updateSubTaskStatusRequestDto.getStatus());

        if (updateSubTaskStatusRequestDto.getStatus() == TaskStatus.COMPLETED) {
            subTaskEntity.setCompletedAt(LocalDateTime.now());
        } else {
            subTaskEntity.setCompletedAt(null);
        }

        SubTaskEntity updatedSubTask =
                subTaskRepository.save(subTaskEntity);
        return SubTaskMapper.toSubTaskResponseDto(updatedSubTask);
    }
}
