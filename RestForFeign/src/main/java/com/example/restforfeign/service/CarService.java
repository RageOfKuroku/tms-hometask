package com.example.restforfeign.service;


import com.example.restforfeign.dto.CarDto;

import java.util.List;

public interface CarService {
    CarDto save(CarDto dto);
    CarDto update(Integer id, CarDto dto);
    CarDto get(Integer id);
    void delete(Integer id);
    List<CarDto> getAll();
}
