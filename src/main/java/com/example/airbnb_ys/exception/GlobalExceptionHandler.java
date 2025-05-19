package com.example.airbnb_ys.exception;

import com.example.airbnb_ys.dto.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<Response<?>> handleDuplicateException(CustomException ex) {
        ErrorCode errorCode = ex.getErrorCode();

        ex.printStackTrace();
        return new ResponseEntity<>(Response.fail(errorCode.getMessage()), errorCode.getStatus());
    }
}