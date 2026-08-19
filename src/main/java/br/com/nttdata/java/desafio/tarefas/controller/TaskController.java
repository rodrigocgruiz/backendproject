package br.com.nttdata.java.desafio.tarefas.controller;

import br.com.nttdata.java.desafio.tarefas.dto.request.CreateTaskRequestDto;
import br.com.nttdata.java.desafio.tarefas.dto.request.UpdateTaskStatusRequestDto;
import br.com.nttdata.java.desafio.tarefas.dto.response.TaskResponseDto;
import br.com.nttdata.java.desafio.tarefas.enums.TaskStatus;
import br.com.nttdata.java.desafio.tarefas.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponseDto> createTask(
            @Valid @RequestBody CreateTaskRequestDto createTaskRequestDto) {

        TaskResponseDto responseDto =
                taskService.createTask(createTaskRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> findById(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                taskService.findById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> findByStatus(
            @RequestParam TaskStatus status) {
        return ResponseEntity.ok(taskService
                .findByStatus(status)
        );
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TaskResponseDto> updateStatus(
            @PathVariable UUID id,
            @RequestBody UpdateTaskStatusRequestDto updateTaskStatusRequestDto) {
        return ResponseEntity.ok(
                taskService.updateStatus(id, updateTaskStatusRequestDto)
        );
    }
}
