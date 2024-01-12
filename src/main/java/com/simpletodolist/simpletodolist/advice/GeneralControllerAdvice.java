package com.simpletodolist.simpletodolist.advice;

import com.simpletodolist.simpletodolist.dto.ErrorMessageDto;
import com.simpletodolist.simpletodolist.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GeneralControllerAdvice {
    private final MessageSource messageSource;

    @Autowired
    public GeneralControllerAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler
    public ResponseEntity<Problem> handleNotFoundException(NotFoundException exception) {
        Problem problem = new Problem(
                HttpStatus.NOT_FOUND.value(),
                "Task not found",
                exception.getMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problem);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Problem> handleNotFoundFieldException(MethodArgumentNotValidException exception) {
        List<ErrorMessageDto> listProblem = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(e -> {
            String detail = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorMessageDto messageDetail = new ErrorMessageDto(
                    e.getField(),
                    detail
            );
            listProblem.add(messageDetail);
        });

        Problem problem = new Problem(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid Parameters",
                "Invalid Request Body",
                listProblem
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }
}
