package com.example.restforfeign.web;


import com.example.restforfeign.dto.CarDto;
import com.example.restforfeign.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService service;
    @GetMapping("/{id}")
    public CarDto find(@PathVariable(name = "id") Integer id) {
        return service.get(id);
    }

    @PostMapping
    public CarDto save(@RequestBody CarDto saveReq){
        return service.save(saveReq);
    }

    @PutMapping
    public CarDto update(@PathVariable(name = "id") Integer id, @RequestBody CarDto req){
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Integer id){
        service.delete(id);
    }

    @GetMapping
    public List<CarDto> findAll(){
        return service.getAll();
    }
}
