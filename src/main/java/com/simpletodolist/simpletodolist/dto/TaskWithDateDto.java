package com.simpletodolist.simpletodolist.dto;

import com.simpletodolist.simpletodolist.entity.Task;
import java.time.LocalDate;

public record TaskWithDateDto(
        Long id,
        String taskName,
        String description,
        LocalDate taskCreationDate,
        PriorityEnum priority
) {
    public static TaskWithDateDto taskToTaskWithDateDto(Task task) {
        return new TaskWithDateDto(
                task.getId(),
                task.getTaskName(),
                task.getDescription(),
                task.getTaskCreationDate(),
                task.getPriority()
        );
    }
}
