package br.com.nttdata.java.desafio.tarefas.dto.request;

import br.com.nttdata.java.desafio.tarefas.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTaskStatusRequestDto {
    private TaskStatus status;
}
