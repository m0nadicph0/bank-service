package com.example.bankservice.advice;

import com.example.bankservice.dto.BusinessError;
import com.example.bankservice.dto.ValidationError;
import com.example.bankservice.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ValidationError> handleMethodArgumentException(WebExchangeBindException exception) {
        return ResponseEntity.badRequest().body(ValidationError.from(exception));
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<BusinessError> handleBusinessException(BusinessException exception) {

        return ResponseEntity.badRequest().body(BusinessError.from(exception));
    }
}