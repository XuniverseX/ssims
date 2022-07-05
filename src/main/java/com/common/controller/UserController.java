package com.common.controller;

import com.common.dto.Result;
import com.common.entity.User;
import com.common.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/login")
    public Result<User> login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    @PostMapping("/register")
    public Result<User> register(@RequestParam String username, @RequestParam String password) {
        return userService.register(username, password);
    }

}
