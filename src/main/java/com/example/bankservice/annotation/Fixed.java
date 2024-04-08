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
    String message() default "The value must be exactly equal to {value} specified in the annotation, but value is {supplied}.";
    String value();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
