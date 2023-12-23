package com.example.feignsecond.web;

import com.example.feignsecond.dto.IlErrorDto;
import com.example.feignsecond.exception.FailedTaskException;
import com.example.feignsecond.mapper.ErrorMapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RequiredArgsConstructor
@RestControllerAdvice
@OpenAPIDefinition(info = @Info(
        title = "Controller for handling errors"
))
public class ExceptionHandlerController {

    private final ErrorMapper mapper;
    @ExceptionHandler(FailedTaskException.class)
    @Operation(tags = "handlers", description = "Too lazy for filling description")
    public ResponseEntity<IlErrorDto> handle(FailedTaskException exception) {
        return ResponseEntity.status(exception.getCode()).body(mapper.toIl(exception));
    }
}
