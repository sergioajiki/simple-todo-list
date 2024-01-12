package com.simpletodolist.simpletodolist.dto;

import com.simpletodolist.simpletodolist.entity.Task;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskDto(
//        Long id,
        @NotBlank(message = "Field taskName can not be null or empty") String taskName,
        String description,
//        LocalDate taskCreationDate,
        @NotNull(message = "Field priority can not be null or empty") PriorityEnum priority
        ) {
    public static TaskDto taskToTaskDto(Task task) {
        return new TaskDto(
                task.getTaskName(),
                task.getDescription(),
                task.getPriority()
        );
    }

    public static Task taskDtoToTask(TaskDto taskDto) {
        Task task = new Task();
        task.setTaskName(taskDto.taskName);
        task.setDescription(taskDto.description);
        task.setPriority(taskDto.priority);
        return task;
    }
}
