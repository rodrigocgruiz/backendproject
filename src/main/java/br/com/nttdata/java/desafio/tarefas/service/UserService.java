package br.com.nttdata.java.desafio.tarefas.service;

import br.com.nttdata.java.desafio.tarefas.dto.request.CreateUserRequestDto;
import br.com.nttdata.java.desafio.tarefas.dto.response.UserResponseDto;
import br.com.nttdata.java.desafio.tarefas.entity.UserEntity;
import br.com.nttdata.java.desafio.tarefas.exception.ResourceNotFoundException;
import br.com.nttdata.java.desafio.tarefas.mapper.UserMapper;
import br.com.nttdata.java.desafio.tarefas.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto createUser(CreateUserRequestDto createUserRequestDto) {
        if (userRepository.existsByEmail(createUserRequestDto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        UserEntity userEntity = UserMapper.toUserEntity(createUserRequestDto);
        UserEntity savedUser = userRepository.save(userEntity);
        return UserMapper.toUserResponseDto(savedUser);
    }

    public UserResponseDto findById(UUID id){
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));
        return UserMapper.toUserResponseDto(userEntity);
    }
}
