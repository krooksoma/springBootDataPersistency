package com.example.demo2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class homepageRestController {

    @GetMapping("/")
    public String Hello(){
        return "HelloWorld" + LocalDateTime.now();
    }
}
