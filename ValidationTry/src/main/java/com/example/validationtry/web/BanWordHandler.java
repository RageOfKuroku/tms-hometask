package com.example.validationtry.web;

import com.example.validationtry.error.BanWordException;
import com.example.validationtry.error.ErrorDescr;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class BanWordHandler {
    @ExceptionHandler(BanWordException.class)
    public ResponseEntity<ErrorDescr> errorDescrResponseEntity(BanWordException exception) {
        String errorMessage = exception.getErrorMessage();
        Integer code = exception.getCode();

        ErrorDescr descr = ErrorDescr.builder().errorMessage(errorMessage).code(code).build();

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(descr);

    }

}
