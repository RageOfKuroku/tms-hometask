package com.example.feignsecond.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarStoreDto {
    private Integer id;

    private String name;
    private String brand;
}
