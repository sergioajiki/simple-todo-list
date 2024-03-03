package com.simpletodolist.simpletodolist.dto;

public enum PriorityEnum {
    HIGH("HIGH"),
    MEDIUM("MEDIUM"),
    LOW("LOW");

    private final String priority;

    PriorityEnum(String priority) {
        this.priority = priority;
    }
    public String getPriority() {
        return priority;
    }
}
