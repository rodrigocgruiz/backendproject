package br.com.nttdata.java.desafio.tarefas.service;

import br.com.nttdata.java.desafio.tarefas.dto.request.CreateTaskRequestDto;
import br.com.nttdata.java.desafio.tarefas.dto.request.UpdateTaskStatusRequestDto;
import br.com.nttdata.java.desafio.tarefas.dto.response.TaskResponseDto;
import br.com.nttdata.java.desafio.tarefas.entity.SubTaskEntity;
import br.com.nttdata.java.desafio.tarefas.entity.TaskEntity;
import br.com.nttdata.java.desafio.tarefas.entity.UserEntity;
import br.com.nttdata.java.desafio.tarefas.enums.TaskStatus;
import br.com.nttdata.java.desafio.tarefas.mapper.TaskMapper;
import br.com.nttdata.java.desafio.tarefas.repository.SubTaskRepository;
import br.com.nttdata.java.desafio.tarefas.repository.TaskRepository;
import br.com.nttdata.java.desafio.tarefas.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final SubTaskRepository subTaskRepository;

    public TaskService(
            TaskRepository taskRepository,
            UserRepository userRepository,
            SubTaskRepository subTaskRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.subTaskRepository = subTaskRepository;
    }
    
    public TaskResponseDto createTask(
            CreateTaskRequestDto createTaskRequestDto) {

        UserEntity userEntity = userRepository
                .findById(createTaskRequestDto.getUserId())
                .orElseThrow(() ->
                        new IllegalArgumentException("User not found"));

        TaskEntity taskEntity = TaskMapper.toTaskEntity(
                createTaskRequestDto, userEntity);

        taskEntity.setStatus(TaskStatus.PENDING);
        taskEntity.setCreatedAt(LocalDateTime.now());

        TaskEntity savedTask = taskRepository.save(taskEntity);
        return TaskMapper.toTaskResponseDto(savedTask);
    }
    
    public TaskResponseDto findById(UUID id) {
        TaskEntity taskEntity = taskRepository.findById(id)
                .orElseThrow(() -> 
                        new IllegalArgumentException("Task not found"));
        return TaskMapper.toTaskResponseDto(taskEntity);
    }

    public TaskResponseDto updateStatus(
        UUID id,
        UpdateTaskStatusRequestDto updateTaskStatusRequestDto) {

        TaskEntity taskEntity = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));

        if (updateTaskStatusRequestDto.getStatus() == TaskStatus.COMPLETED) {
            List<SubTaskEntity> subTaskEntities = subTaskRepository.findByTaskId(id);
            boolean hasIncompleteSubTasks = subTaskEntities.stream()
                    .anyMatch(subTask ->
                            subTask.getStatus() != TaskStatus.COMPLETED);

            if (hasIncompleteSubTasks) {
                throw new IllegalStateException(
                        "Task cannot be completed while there are incomplete subtasks");
            }

            taskEntity.setCompletedAt(LocalDateTime.now());
        }else {
            taskEntity.setCompletedAt(null);
        }
        taskEntity.setStatus(updateTaskStatusRequestDto.getStatus());
        TaskEntity updatedTask = taskRepository.save(taskEntity);
        return TaskMapper.toTaskResponseDto(updatedTask);
    }

    public List<TaskResponseDto> findByStatus(TaskStatus status) {

        return taskRepository.findByStatus(status)
                .stream()
                .map(TaskMapper::toTaskResponseDto)
                .toList();
    }
}
