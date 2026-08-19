package br.com.nttdata.java.desafio.tarefas.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateSubTaskRequestDto {
    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotNull(message = "Task ID is required")
    private UUID taskId;
}
