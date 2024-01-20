package com.simpletodolist.simpletodolist.service;

import com.simpletodolist.simpletodolist.dto.*;
import com.simpletodolist.simpletodolist.entity.Task;
import com.simpletodolist.simpletodolist.exception.NotFoundException;
import com.simpletodolist.simpletodolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        taskToSave.setCurrentState(StatusEnum.INPROGRESS);

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
                    task.getPriority(),
                    task.getCurrentState(),
                    task.getTaskDoneDate()
            );
            fullList.add(taskWithDateDto);
        });
        return fullList;
    }

    public TaskWithDateDto updateDoneById(Long id) {
        Task taskToUpdate = verifyId(id);
        taskToUpdate.setTaskDoneDate(LocalDate.now());
        taskToUpdate.setCurrentState(StatusEnum.DONE);
        taskRepository.save(taskToUpdate);
        TaskWithDateDto taskToUpdateDto = TaskWithDateDto.taskToTaskWithDateDto(taskToUpdate);
        return taskToUpdateDto;
    }

    public TaskWithDateDto updateInProgressById(Long id) {
        Task taskToUpdate = verifyId(id);
        taskToUpdate.setTaskDoneDate(null);
        taskToUpdate.setCurrentState(StatusEnum.INPROGRESS);
        taskRepository.save(taskToUpdate);
        TaskWithDateDto taskToUpdateDto = TaskWithDateDto.taskToTaskWithDateDto(taskToUpdate);
        return taskToUpdateDto;
    }

    public TaskWithDateDto updatePriorityById(Long id, PriorityDto priority) {
        Task taskToUpdate = verifyId(id);
        taskToUpdate.setPriority(priority.priority());
        taskRepository.save(taskToUpdate);
        TaskWithDateDto taskToUpdateDto = TaskWithDateDto.taskToTaskWithDateDto(taskToUpdate);
        return taskToUpdateDto;
    }

    public String deleteTask(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isEmpty()) {
            throw new NotFoundException("Id " + id + " does not match any task");
        }
        taskRepository.deleteById(id);
        return "Tarefa com o id " + id + " apagada com sucesso";
    }

    private Task verifyId(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isEmpty()) {
            throw new NotFoundException("Id " + id + " does not match any task");
        }
        return taskOptional.get();
    }
}