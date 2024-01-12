package com.simpletodolist.simpletodolist.dto;

public enum PriorityEnum {
    HIGH("PRIORITY_HIGH"),
    MEDIUM("PRIORITY_MEDIUM"),
    LOW("PRIORITY_LOW");

    private final String priority;

    PriorityEnum(String priority) {
        this.priority = priority;
    }
    public String getPriority() {
        return priority;
    }
}
