package com.bosonit.block7crudvalidation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Date;

@ControllerAdvice
public class CustomExceptionHandler  {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> handEntityCustomExceptionHandler(EntityNotFoundException e){
        CustomError customError = new CustomError(
                new Date(),
                HttpStatus.NOT_FOUND.value(),
                e.getMessage());
        return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {UnprocessableEntityException.class})
    public ResponseEntity<Object> handUnprocessableCustomExceptionHandler(UnprocessableEntityException e){
    CustomError customError = new CustomError(
            new Date(),
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            e.getMessage());
        return new ResponseEntity<>(customError, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
