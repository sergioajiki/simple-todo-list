package com.simpletodolist.simpletodolist.dto;

public enum StatusEnum {
    INPROGRESS("INPROGRESS"),
    DONE("DONE");

    private final String currentState;
    StatusEnum(String currentState) {
        this.currentState = currentState;
    }
    public String getCurrentState() { return currentState; }
}
