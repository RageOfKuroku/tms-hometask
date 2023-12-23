package com.example.restforfeign.exception;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class FailedTaskException extends RuntimeException{

    private final String exMessage;

    public FailedTaskException(String exMessage) {
        super(exMessage);
        this.exMessage = exMessage;
    }
}
