package com.example.resttest.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String name;
    private String password;
    private Role role;
}
