package com.example.secondresttest.repository;

import com.example.secondresttest.dto.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDto, Integer> {
}
