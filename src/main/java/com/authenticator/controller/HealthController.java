package com.authenticator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Health {
    
    @GetMapping("/")
    public String health(){
        return "<h1>Hello, I am working</h1>";
    }
}
