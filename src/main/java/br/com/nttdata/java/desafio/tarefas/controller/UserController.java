package br.com.nttdata.java.desafio.tarefas.controller;

import br.com.nttdata.java.desafio.tarefas.dto.request.CreateUserRequestDto;
import br.com.nttdata.java.desafio.tarefas.dto.response.UserResponseDto;
import br.com.nttdata.java.desafio.tarefas.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser (
        @Valid @RequestBody CreateUserRequestDto createUserRequestDto){

        UserResponseDto responseDto = userService.createUser(createUserRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                userService.findById(id)
        );
    }
}
