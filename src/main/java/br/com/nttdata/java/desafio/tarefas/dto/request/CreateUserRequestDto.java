package br.com.nttdata.java.desafio.tarefas.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequestDto {
    private String name;
    private String email;
}
