package com.example.validationtry.error;

import lombok.Getter;

@Getter
public class BanWordException extends RuntimeException {

    private final String errorMessage;
    private final Integer code;

    public BanWordException(String errorMessage, Integer code) {
        this.errorMessage = errorMessage;
        this.code = code;
    }
}
