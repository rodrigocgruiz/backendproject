package br.com.nttdata.java.desafio.tarefas.mapper;

import br.com.nttdata.java.desafio.tarefas.dto.request.CreateTaskRequestDto;
import br.com.nttdata.java.desafio.tarefas.dto.response.TaskResponseDto;
import br.com.nttdata.java.desafio.tarefas.entity.TaskEntity;
import br.com.nttdata.java.desafio.tarefas.entity.UserEntity;

public class TaskMapper {

    public static TaskEntity toTaskEntity(CreateTaskRequestDto createTaskRequestDto, UserEntity userEntity) {
        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setTitle(createTaskRequestDto.getTitle());
        taskEntity.setDescription(createTaskRequestDto.getDescription());
        taskEntity.setUser(userEntity);

        return taskEntity;
    }

    public static TaskResponseDto toTaskResponseDto(TaskEntity taskEntity) {
        TaskResponseDto taskResponseDto = new TaskResponseDto();

        taskResponseDto.setId(taskEntity.getId());
        taskResponseDto.setTitle(taskEntity.getTitle());
        taskResponseDto.setDescription(taskEntity.getDescription());
        taskResponseDto.setStatus(taskEntity.getStatus());
        taskResponseDto.setCreatedAt(taskEntity.getCreatedAt());
        taskResponseDto.setCompletedAt(taskEntity.getCompletedAt());
        taskResponseDto.setUserId(taskEntity.getUser().getId());

        return taskResponseDto;
    }
}
