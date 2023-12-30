package com.example.validationtry.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MovieTitleValidator.class)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidMovieTitle {
    String message() default "Invalid movie title";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

