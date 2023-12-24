package com.example.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping("/public")
    public String publicPage(){
        return "public";
    }

    @GetMapping("/private")
    public String privatePage(){
        return "private";
    }

    @GetMapping("/protected")
    public String protectedPage(){
        return "protected";
    }

    @GetMapping("/user")
    public String userPage(){
        return "user";
    }
}
