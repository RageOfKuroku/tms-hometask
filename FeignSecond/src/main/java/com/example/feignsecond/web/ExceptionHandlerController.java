package com.example.feignsecond.web;

import com.example.feignsecond.dto.IlErrorDto;
import com.example.feignsecond.exception.FailedTaskException;
import com.example.feignsecond.mapper.ErrorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionHandlerController {

    private final ErrorMapper mapper;
    @ExceptionHandler(FailedTaskException.class)
    public ResponseEntity<IlErrorDto> handle(FailedTaskException exception) {


        return ResponseEntity.status(exception.getCode()).body(mapper.toIl(exception));
    }
}
