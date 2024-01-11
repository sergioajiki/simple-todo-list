package com.simpletodolist.simpletodolist.dto;

import com.simpletodolist.simpletodolist.entity.Task;
import jakarta.validation.constraints.NotBlank;

public record TaskDto(
//        Long id,
        @NotBlank(message = "Field taskName can not be null or empty") String taskName,
        String description,
//        LocalDate taskCreationDate,
        @NotBlank(message = "Field priority can not be null or empty") String priority
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

    ;
}
