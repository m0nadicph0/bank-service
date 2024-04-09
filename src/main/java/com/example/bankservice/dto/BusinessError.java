package com.example.bankservice.dto;

import com.example.bankservice.exception.BusinessException;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BusinessError {
    private String category;
    private String message;
    private String code;

    public static BusinessError from(BusinessException exception) {
        return BusinessError.builder()
                .category(exception.getCategory())
                .code(exception.getCode())
                .message(exception.getMessage())
                .build();
    }
}
