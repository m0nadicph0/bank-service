package com.example.bankservice.annotation;

import com.example.bankservice.validator.FixedValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = FixedValidator.class)
public @interface Fixed {
    String message() default "value should be equal to fixed";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
