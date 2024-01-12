package com.simpletodolist.simpletodolist.dto;

import jakarta.validation.constraints.NotNull;

public record PriorityDto(
        @NotNull(message = "Field priority can not be null or empty") PriorityEnum priority
) {
}
