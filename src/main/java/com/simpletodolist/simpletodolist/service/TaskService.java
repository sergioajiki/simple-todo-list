package com.simpletodolist.simpletodolist.service;

import com.simpletodolist.simpletodolist.dto.TaskDto;
import com.simpletodolist.simpletodolist.entity.Task;
import com.simpletodolist.simpletodolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskDto create(TaskDto taskDto) {
        Task taskToSave = TaskDto.taskDtoToTask(taskDto);
        taskRepository.save(taskToSave);
        TaskDto savedTask = TaskDto.taskToTaskDto(taskToSave);

        return savedTask;
    }
}
