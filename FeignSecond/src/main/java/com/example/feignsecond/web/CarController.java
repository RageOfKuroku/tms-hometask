package com.example.feignsecond.web;

import com.example.feignsecond.dto.CarStoreDto;
import com.example.feignsecond.service.CarStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarStoreService service;
    @PostMapping
    public CarStoreDto save(@RequestBody CarStoreDto dto) {
        return service.carReg(dto);
    }

    @GetMapping("/find/{id}")
    public CarStoreDto findById(@PathVariable(name = "id") Integer id){
        return service.findById(id);
    }

}

