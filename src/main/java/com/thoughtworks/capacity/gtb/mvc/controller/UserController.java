package com.thoughtworks.capacity.gtb.mvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("/register")
    public ResponseEntity register(){
        return ResponseEntity.ok().build();
    }
}
