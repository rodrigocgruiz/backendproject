package br.com.nttdata.java.desafio.tarefas.mapper;

import br.com.nttdata.java.desafio.tarefas.dto.request.CreateSubTaskRequestDto;
import br.com.nttdata.java.desafio.tarefas.dto.response.SubTaskResponseDto;
import br.com.nttdata.java.desafio.tarefas.entity.SubTaskEntity;
import br.com.nttdata.java.desafio.tarefas.entity.TaskEntity;

public class SubTaskMapper {

    public static SubTaskEntity toSubTaskEntity(CreateSubTaskRequestDto createSubTaskRequestDto, TaskEntity taskEntity) {
        SubTaskEntity subTaskEntity = new SubTaskEntity();

        subTaskEntity.setTitle(createSubTaskRequestDto.getTitle());
        subTaskEntity.setDescription(createSubTaskRequestDto.getDescription());
        subTaskEntity.setTask(taskEntity);

        return subTaskEntity;
    }

    public static SubTaskResponseDto toSubTaskResponseDto (SubTaskEntity subTaskEntity){
        SubTaskResponseDto subTaskResponseDto = new SubTaskResponseDto();

        subTaskResponseDto.setId(subTaskEntity.getId());
        subTaskResponseDto.setTitle(subTaskEntity.getTitle());
        subTaskResponseDto.setDescription(subTaskEntity.getDescription());
        subTaskResponseDto.setStatus(subTaskEntity.getStatus());
        subTaskResponseDto.setCreatedAt(subTaskEntity.getCreatedAt());
        subTaskResponseDto.setCompletedAt(subTaskEntity.getCompletedAt());
        subTaskResponseDto.setTaskId(subTaskEntity.getTask().getId());

        return subTaskResponseDto;
    }
}
