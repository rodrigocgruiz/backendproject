package br.com.nttdata.java.desafio.tarefas.controller;

import br.com.nttdata.java.desafio.tarefas.dto.request.CreateSubTaskRequestDto;
import br.com.nttdata.java.desafio.tarefas.dto.request.UpdateTaskStatusRequestDto;
import br.com.nttdata.java.desafio.tarefas.dto.response.SubTaskResponseDto;
import br.com.nttdata.java.desafio.tarefas.service.SubTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/subtasks")
public class SubTaskController {

    private final SubTaskService subTaskService;

    public SubTaskController(SubTaskService subTaskService) {
        this.subTaskService = subTaskService;
    }

    @PostMapping
    public ResponseEntity<SubTaskResponseDto> createSubTask(
            @RequestBody CreateSubTaskRequestDto createSubTaskRequestDto) {

        SubTaskResponseDto responseDto =
                subTaskService.createSubTask(createSubTaskRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubTaskResponseDto> findById(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                subTaskService.findById(id)
        );
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<SubTaskResponseDto>> findByTaskId(
            @PathVariable UUID taskId) {
        return ResponseEntity.ok(
                subTaskService.findByTaskId(taskId)
        );
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<SubTaskResponseDto> updateStatus(
            @PathVariable UUID id,
            @RequestBody UpdateTaskStatusRequestDto updateTaskStatusRequestDto){

        return ResponseEntity.ok(
                subTaskService.updateStatus(id, updateTaskStatusRequestDto)
        );
    }
}
