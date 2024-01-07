package com.example.resttest.service;

import com.example.resttest.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.resttest.model.Role.USER;

@Service
@RequiredArgsConstructor
public class UserService {

    private final DataService dataService;

    public void save(String username, String password){
        User user = User.builder()
                .name(username)
                .password(password)
                .role(USER)
                .build();

    }

}
