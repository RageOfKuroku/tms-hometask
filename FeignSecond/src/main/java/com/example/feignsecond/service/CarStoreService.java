package com.example.feignsecond.service;


import com.example.feignsecond.dto.CarStoreDto;
import org.springframework.stereotype.Service;

@Service
public interface CarStoreService {

    CarStoreDto carReg(CarStoreDto dto);

    CarStoreDto findById(Integer id);
}
