package com.bosonit.block7crudvalidation.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class CustomError {
    private final Date date;
    private final int httpCode;
    private final String message;

    public CustomError(Date date, int httpCode, String message) {
        this.date = date;
        this.httpCode = httpCode;
        this.message = message;
    }
}
