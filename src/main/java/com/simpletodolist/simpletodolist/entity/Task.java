package com.simpletodolist.simpletodolist.entity;

import com.simpletodolist.simpletodolist.dto.PriorityEnum;
import com.simpletodolist.simpletodolist.dto.StatusEnum;
import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taskName;
    private String description;
    private LocalDate taskCreationDate = LocalDate.now();
    private PriorityEnum priority;
    private StatusEnum currentState;
    private LocalDate taskDoneDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTaskCreationDate() {
        return taskCreationDate;
    }

    //    public void setTaskCreationDate(LocalDate taskCreationDate) { this.taskCreationDate = taskCreationDate; }
    public void setTaskCreationDate(LocalDate taskCreationDate) {
        this.taskCreationDate = taskCreationDate;
    }

    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }

    public StatusEnum getCurrentState() { return currentState; }

    public void setCurrentState(StatusEnum currentState) { this.currentState = currentState; }

    public LocalDate getTaskDoneDate() { return taskDoneDate; }

    public void setTaskDoneDate(LocalDate taskDoneDate) { this.taskDoneDate = taskDoneDate; }
}
