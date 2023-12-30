package com.example.security.web;

import com.example.security.dto.UserDto;
import com.example.security.service.DBUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final DBUserDetailsService service;
    @PostMapping("/register")
    public String save(UserDto user) {
        service.save(user);
        return "public";
    }
}
