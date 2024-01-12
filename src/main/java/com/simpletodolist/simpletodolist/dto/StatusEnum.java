package com.simpletodolist.simpletodolist.dto;

public enum StatusEnum {
    INPROGRESS("INPROGRESS"),
    DONE("DONE"),

    private final String inProgress;
    StatusEnum(String inProgress) {
        this.inProgress = inProgress;
    }
    public String getInProgress() { return inProgress; }
}
