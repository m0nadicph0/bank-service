package com.example.bankservice.validator;

import com.example.bankservice.annotation.Fixed;
import com.example.bankservice.annotation.USPhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class USPhoneNumberValidator implements ConstraintValidator<USPhoneNumber, String> {
    private static final String US_PHONE_PATTERN = "^\\+?1?\\s?\\(?\\d{3}\\)?[-\\s]?\\d{3}[-\\s]?\\d{4}$";

    @Override
    public void initialize(USPhoneNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cxt) {
        if (value == null || value.trim().isEmpty()) {
            return true; // Consider empty values as valid. Use @NotNull for null checks.
        }
        return value.matches(US_PHONE_PATTERN);
    }
}
