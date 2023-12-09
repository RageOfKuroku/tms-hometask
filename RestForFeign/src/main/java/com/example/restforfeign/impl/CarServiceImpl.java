package com.example.restforfeign.impl;


import com.example.restforfeign.dto.CarDto;
import com.example.restforfeign.entity.CarEntity;
import com.example.restforfeign.exception.FailedTaskException;
import com.example.restforfeign.mapper.CarMapper;
import com.example.restforfeign.repos.CarRepository;
import com.example.restforfeign.service.CarService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CarServiceImpl implements CarService {

    private final CarRepository repository;

    private final CarMapper mapper;

    @Override
    public CarDto save(CarDto dto) {
        CarEntity entity = mapper.toEntity(dto);

        CarEntity saved = repository.save(entity);

        return mapper.toDto(saved);

    }

    @Override
    public CarDto update(Integer id, CarDto dto) {
        var car = repository.findById(id)
                .orElseThrow(() -> new FailedTaskException("Something went wrong"));

        mapper.update(car, dto);

        return mapper.toDto(car);

    }

    @Override
    public CarDto get(Integer id) {
        var car = repository.findById(id)
                .orElseThrow(() -> new FailedTaskException("Something went wrong"));
        return mapper.toDto(car);
    }

    @Override
    public void delete(Integer id) {
        var car = repository.findById(id)
                .orElseThrow(() -> new FailedTaskException("Something went wrong"));
        repository.delete(car);
    }

    @Override
    public List<CarDto> getAll() {
        List<CarEntity> all = repository.findAll();
        return mapper.toDtos(all);
    }
}
