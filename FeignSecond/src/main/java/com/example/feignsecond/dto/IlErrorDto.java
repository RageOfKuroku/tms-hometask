package com.example.feignsecond.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class IlErrorDto {
    private String errorDetails;
    private String serviceName;
    private String action;
}
