package com.simpletodolist.simpletodolist.controller;

import com.simpletodolist.simpletodolist.dto.TaskDto;
import com.simpletodolist.simpletodolist.dto.TaskWithDateDto;
import com.simpletodolist.simpletodolist.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Tasks")
@RequestMapping(value = "/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @Operation(description = "Registrar Tarefa")
    public ResponseEntity<TaskWithDateDto> createTask(@RequestBody @Valid TaskDto taskDto) {
        TaskWithDateDto createdTask = taskService.create(taskDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @GetMapping
    @Operation(description = "Lista completa de tarefas")
    public ResponseEntity<List<TaskWithDateDto>> getAllTasks(){
        List<TaskWithDateDto> allTasks = taskService.getAllTasks();
        return ResponseEntity.status(HttpStatus.OK).body(allTasks);
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Delete task by id")
    public ResponseEntity<String> deleteUserById(@PathVariable @Valid Long id) {
        System.out.println("esse é o id" + id);
        String result = taskService.deleteTask(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
