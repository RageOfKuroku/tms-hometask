package com.example.restforfeign.web;

import com.example.restforfeign.exception.ExInfo;
import com.example.restforfeign.exception.FailedTaskException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(FailedTaskException.class)
    public ResponseEntity<ExInfo> handler(FailedTaskException exc){
        String errorMessage = exc.getMessage();
        ExInfo details = ExInfo.builder()
                .serviceName("user-service")
                .message(errorMessage)
                .code(400)
                .build();

        return ResponseEntity.status(400).body(details);
    }
}
