package com.example.bankservice.validator;

import com.example.bankservice.annotation.Fixed;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FixedValidator implements ConstraintValidator<Fixed, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value.equalsIgnoreCase("fixed");
    }
}
