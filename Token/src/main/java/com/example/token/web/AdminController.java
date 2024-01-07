package com.example.token.web;

import com.example.token.dto.UserDto;
import com.example.token.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor

@RestController
@RequestMapping
public class AdminController {
    private final UserServiceImpl service;

    @GetMapping("/main")
    public String mainPage(){
        return "mainPage";
    }
    @GetMapping("/admin")
    public String admin(){
        return "adminPage";
    }

    @PostMapping("/auth")
    public ResponseEntity<UserDto> save(@RequestBody UserDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(dto));
    }
}

