package com.example.bankservice.annotation;

import com.example.bankservice.validator.FixedValidator;
import com.example.bankservice.validator.USPhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = USPhoneNumberValidator.class)
public @interface USPhoneNumber {
    String message() default "Invalid US phone number format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
