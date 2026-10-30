package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
        public String register(@RequestBody User user){
        userService.register(user);
        return "注册成功！";
    }

    @GetMapping("/login")
    public String login(@RequestBody User user){
        userService.login(user);
        return "登录成功！";
    }
}
