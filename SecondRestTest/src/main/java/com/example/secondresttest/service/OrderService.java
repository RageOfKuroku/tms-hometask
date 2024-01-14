package com.example.secondresttest.service;

import com.example.secondresttest.dto.OrderDto;
import com.example.secondresttest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderDto save(OrderDto order) {
        return orderRepository.save(order);
    }
}
