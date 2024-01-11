package com.simpletodolist.simpletodolist.advice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.simpletodolist.simpletodolist.dto.ErrorMessageDto;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Problem(
        int status,
        String message,
        String detail,
        List<ErrorMessageDto> errors
) {}
