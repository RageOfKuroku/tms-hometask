package com.example.validationtry.validate;

import com.example.validationtry.error.BanWordException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class MovieTitleValidator implements ConstraintValidator<ValidMovieTitle, String> {

    List<String> blackList = Arrays.asList("kishki", "sosiski", "cucumber");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return checkValid(value, context);
    }

    public boolean checkValid(String value, ConstraintValidatorContext context) throws BanWordException {
        if (blackList.contains(value)) {
            throw new BanWordException(context.getDefaultConstraintMessageTemplate() + " " + value, 400);
        }
        return true;
    }
}

