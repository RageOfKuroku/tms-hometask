package com.example.secondresttest.web;

import com.example.secondresttest.dto.OrderDto;
import com.example.secondresttest.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")

public class OrderController {
    OrderService service;
    @PostMapping("/save")
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDto order){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(order));
    }
}