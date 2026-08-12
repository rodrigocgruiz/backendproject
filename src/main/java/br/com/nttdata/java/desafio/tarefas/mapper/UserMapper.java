package br.com.nttdata.java.desafio.tarefas.mapper;

import br.com.nttdata.java.desafio.tarefas.dto.request.CreateUserRequestDto;
import br.com.nttdata.java.desafio.tarefas.dto.response.UserResponseDto;
import br.com.nttdata.java.desafio.tarefas.entity.UserEntity;

public class UserMapper {

    public static UserEntity toUserEntity(CreateUserRequestDto createUserRequestDto) {
        UserEntity userEntity = new UserEntity();

        userEntity.setName(createUserRequestDto.getName());
        userEntity.setEmail(createUserRequestDto.getEmail());

        return userEntity;
    }

    public static UserResponseDto toUserResponseDto(UserEntity userEntity) {
        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId(userEntity.getId());
        userResponseDto.setName(userEntity.getName());
        userResponseDto.setEmail(userEntity.getEmail());

        return userResponseDto;
    }
}
