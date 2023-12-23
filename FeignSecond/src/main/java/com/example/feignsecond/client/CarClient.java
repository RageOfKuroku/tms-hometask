package com.example.feignsecond.client;

import com.example.feignsecond.dto.CarStoreDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "car-client", url = "http://127.0.0.1:8081", path = "/cars")
public interface CarClient {
    @PostMapping
    CarStoreDto save(@RequestBody CarStoreDto request);

    @GetMapping("/find/{id}")
    CarStoreDto findById(@PathVariable(name = "id") Integer id);
}
