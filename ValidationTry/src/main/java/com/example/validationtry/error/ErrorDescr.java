package com.example.validationtry.error;

import lombok.Builder;

@Builder
public class ErrorDescr {

    private String errorMessage;
    private String errorDescr;
    private Integer code;

}
