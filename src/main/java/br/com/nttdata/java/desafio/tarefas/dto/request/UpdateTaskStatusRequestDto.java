package br.com.nttdata.java.desafio.tarefas.dto.request;

import br.com.nttdata.java.desafio.tarefas.enums.TaskStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTaskStatusRequestDto {
    @NotNull(message = "Status is required")
    private TaskStatus status;
}
