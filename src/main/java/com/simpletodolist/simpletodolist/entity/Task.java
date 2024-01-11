package com.simpletodolist.simpletodolist.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String taskName;
    private String description;
    private LocalDate taskCreationDate;
    private String priority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public void setTaskCreationDate(LocalDate taskCreationDate) {
        this.taskCreationDate = taskCreationDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        priority = priority;
    }

}
