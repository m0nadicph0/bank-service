package com.example.bankservice.validator;

import com.example.bankservice.annotation.RoutingNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RoutingNumberValidator implements ConstraintValidator<RoutingNumber, String> {
    private static final String ROUTING_NUMBER_PATTERN = "^\\d{9}$";

    @Override
    public void initialize(RoutingNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String routingNumber, ConstraintValidatorContext cxt) {
        if (routingNumber == null || routingNumber.trim().isEmpty()) {
            return true; // Consider empty values as valid. Use @NotNull for null checks.
        }
        return routingNumber.matches(ROUTING_NUMBER_PATTERN);
    }
}
