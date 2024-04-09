package com.example.bankservice.dto;

import com.example.bankservice.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ValidationError {
    private String category;
    private Map<String, String> reasons;
    private String code;

    public static ValidationError from(WebExchangeBindException exception) {
        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return ValidationError.builder()
                .category("validation_error")
                .reasons(errorMap)
                .code("invalid_request")
                .build();
    }
}
