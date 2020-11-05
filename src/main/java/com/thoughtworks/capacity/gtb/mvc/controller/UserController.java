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
    public ResponseEntity register(@RequestBody @Valid User user){
        userService.register(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/login?username={username}&password={password}")
    public ResponseEntity login(@PathVariable String username,@PathVariable String password){
        User userPO = userService.login(username, password);
        return ResponseEntity.ok(userPO);
    }

}
