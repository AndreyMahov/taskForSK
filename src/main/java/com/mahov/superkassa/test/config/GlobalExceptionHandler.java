package com.mahov.superkassa.test.config;

import com.mahov.superkassa.test.domain.exception.ObjectNotFound;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> allExceptions(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
                .body(new ErrorResponse("сервер не может приготовить кофе, потому что он чайник"));
    }

    @Value
    public static class ErrorResponse {
        String message;
    }

}
