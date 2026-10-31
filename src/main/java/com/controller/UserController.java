package com.controller;

import com.dto.request.UserLoginRequest;
import com.dto.request.UserRegisterRequest;
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
        public String register(@RequestBody UserRegisterRequest request ){
        userService.register(request);
        return "注册成功！";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginRequest request){
        userService.login(request);
        return "登录成功！";
    }
}
