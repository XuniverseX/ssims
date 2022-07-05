package com.common.controller;

import com.common.dto.PageDTO;
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

    @GetMapping
    public Result<PageDTO<User>> getAll(@RequestParam(value = "current", defaultValue = "1") Integer current,
                                        @RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize) {
        return userService.getAll(current, pageSize);
    }

    @GetMapping("/{id}")
    public Result<User> getUserById(@PathVariable Long id) {
        User user = userService.getById(id);
        if (user == null) {
            return Result.fail("用户不存在");
        }
        return Result.success(user);
    }

    @PutMapping
    public Result<Object> updateUserById(@RequestBody User user) {
        if (!userService.updateById(user)) {
            return Result.fail("更新失败");
        }
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<Object> deleteUserById(@PathVariable Long id) {
        if (!userService.removeById(id)) {
            return Result.fail("用户删除失败");
        }
        return Result.success();
    }

}
