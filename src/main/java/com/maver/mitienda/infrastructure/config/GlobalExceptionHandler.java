package com.maver.mitienda.infrastructure.config;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler
{
    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException exception)
    {
        Map<String,Object> errors = new HashMap<>();

        errors.put("title", "Error de validacion");
        errors.put("code", "invalid_form");
        errors.put("status", HttpStatus.UNPROCESSABLE_ENTITY.value());

        List<String> errorList = new ArrayList<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors())
        {
            String message = messageSource.getMessage(fieldError, Locale.getDefault());
            errorList.add(message);
        }
        errors.put("errors", errorList);
        return new ResponseEntity<>(errors,HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
