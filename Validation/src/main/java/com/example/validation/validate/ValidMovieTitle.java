package com.example.validation.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MovieTitleValidator.class)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMovieTitle {
    String message() default "Invalid movie title";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

