package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.entity.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Validated
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
    public ResponseEntity login(@RequestParam @Size(min = 3, max = 10, message = "用户名长度要求为3到10位")
                                @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "用户名只能由字母、数字或下划线组成") String username
            , @RequestParam @Size(min = 5, max = 12, message = "密码长度要求为5到12位") String password) {
        User user = userService.login(username, password);
        return ResponseEntity.ok(user);
    }

}
