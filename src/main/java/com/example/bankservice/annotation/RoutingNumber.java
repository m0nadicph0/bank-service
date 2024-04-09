package com.example.bankservice.annotation;

import com.example.bankservice.validator.RoutingNumberValidator;
import com.example.bankservice.validator.USPhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = RoutingNumberValidator.class)
public @interface RoutingNumber {
    String message() default "Invalid routing number format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
