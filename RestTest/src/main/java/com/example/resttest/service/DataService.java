package com.example.resttest.service;

import com.example.resttest.model.User;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    public User save(User user) {
        throw new RuntimeException();
    }

}
