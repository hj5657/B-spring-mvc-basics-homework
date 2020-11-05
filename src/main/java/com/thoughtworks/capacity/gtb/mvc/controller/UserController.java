package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.entity.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid User user) {
        userService.register(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestParam String username, @RequestParam String password) {
        User user = userService.login(username, password);
        return ResponseEntity.ok(user);
    }

}
