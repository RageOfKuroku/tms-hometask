package com.example.restforfeign.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionInfoView {
    public ResponseEntity<ExInfo> getExc(FailedTaskException ex){
        String message = ex.getMessage();
        ExInfo exception = ExInfo.builder()
                .serviceName("car-service")
                .message(message)
                .code(400)
                .build();
        return ResponseEntity
                .status(400)
                .body(exception);
    }
}
