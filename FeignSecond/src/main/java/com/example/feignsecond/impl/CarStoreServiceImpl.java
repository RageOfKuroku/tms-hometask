package com.example.feignsecond.impl;

import com.example.feignsecond.client.CarClient;
import com.example.feignsecond.dto.CarStoreDto;
import com.example.feignsecond.service.CarStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CarStoreServiceImpl implements CarStoreService {

    private final CarClient client;
    @Override
    public CarStoreDto carReg(CarStoreDto dto) {
        return client.save(dto);
    }

    @Override
    public CarStoreDto findById(Integer id) {
        return client.findById(id);
    }
}
