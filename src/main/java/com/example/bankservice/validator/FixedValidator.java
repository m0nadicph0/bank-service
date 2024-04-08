package com.example.bankservice.validator;

import com.example.bankservice.annotation.Fixed;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FixedValidator implements ConstraintValidator<Fixed, String> {
    private String expected;
    @Override
    public void initialize(Fixed constraintAnnotation) {
        expected = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValid = expected.equalsIgnoreCase(value);
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()
                            .replaceAll("\\{value}", this.expected).replaceAll("\\{supplied}", value))
                    .addConstraintViolation();
        }
        return isValid;
    }
}
