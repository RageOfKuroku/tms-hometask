package com.example.validation.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class MovieTitleValidator implements ConstraintValidator<ValidMovieTitle, String> {

    List<String> blackList = Arrays.asList("kishki", "sosiski", "cucumber");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (blackList.contains(value)) {
            return false;
        }
        return true;
    }
}

