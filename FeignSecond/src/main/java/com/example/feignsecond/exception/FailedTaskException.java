package com.example.feignsecond.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter

public class FailedTaskException extends RuntimeException{
    @JsonProperty("message")
    private final String exMessage;

    private final String serviceName;
    private final Integer code;

    public FailedTaskException(String exMessage, String serviceName, Integer code) {
        super(exMessage);
        this.exMessage = exMessage;
        this.serviceName = serviceName;
        this.code = code;
    }
}
