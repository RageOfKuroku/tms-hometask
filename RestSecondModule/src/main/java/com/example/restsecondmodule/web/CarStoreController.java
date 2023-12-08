package com.example.restsecondmodule.web;

import com.example.restsecondmodule.dto.CarDto;
import com.example.restsecondmodule.service.CarStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store/cars")
@RequiredArgsConstructor
public class CarStoreController {

    private final CarStoreService service;
    @PostMapping
    public CarDto save(@RequestBody CarDto dto){
        return service.carReg(dto);
    }
}
