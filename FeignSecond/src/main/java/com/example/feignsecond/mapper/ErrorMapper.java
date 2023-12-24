package com.example.feignsecond.mapper;

import com.example.feignsecond.dto.IlErrorDto;
import com.example.feignsecond.exception.FailedTaskException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ErrorMapper {
    @Mapping(target = "errorDetails", source = "message")
    @Mapping(target = "serviceName", source="serviceName")
    @Mapping(target = "action", constant = "save user")
    IlErrorDto toIl(FailedTaskException exception);
}
