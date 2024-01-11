package com.simpletodolist.simpletodolist.service;

import com.simpletodolist.simpletodolist.dto.TaskDto;
import com.simpletodolist.simpletodolist.dto.TaskWithDateDto;
import com.simpletodolist.simpletodolist.entity.Task;
import com.simpletodolist.simpletodolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskWithDateDto create(TaskDto taskDto) {
        Task taskToSave = TaskDto.taskDtoToTask(taskDto);
        taskRepository.save(taskToSave);
        TaskWithDateDto savedTask = TaskWithDateDto.taskToTaskWithDateDto(taskToSave);
        return savedTask;
    }

    public List<TaskWithDateDto> getAllTasks() {
        List<Task> listTask = taskRepository.findAll();
        List<TaskWithDateDto> fullList = new ArrayList<>();
        listTask.forEach(task -> {
            TaskWithDateDto taskWithDateDto = new TaskWithDateDto(
                    task.getId(),
                    task.getTaskName(),
                    task.getDescription(),
                    task.getTaskCreationDate(),
                    task.getPriority()
            );
            fullList.add(taskWithDateDto);
        });
        return fullList;
    }

    public String deleteTask(Long id) {
        taskRepository.deleteById(id);
        return "Tarefa com o id " + id + " apagada com sucesso";
    }
}
