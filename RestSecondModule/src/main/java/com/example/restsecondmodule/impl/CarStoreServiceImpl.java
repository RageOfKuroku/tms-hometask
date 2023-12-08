package com.example.restsecondmodule.impl;

import com.example.restsecondmodule.dto.CarDto;
import com.example.restsecondmodule.service.CarStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@RequiredArgsConstructor
@Service
public class CarStoreServiceImpl implements CarStoreService {

    private final RestTemplate template;
    @Override
    public CarDto carReg(CarDto dto) {
        var carDtoResponseEntity = template.postForEntity("http://127.0.0.1:8081/cars", dto, CarDto.class);
        return carDtoResponseEntity.getBody();
    }
}
