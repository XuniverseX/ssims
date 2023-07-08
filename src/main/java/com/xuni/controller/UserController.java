package com.xuni.controller;

import com.xuni.dto.PageDTO;
import com.xuni.dto.Result;
import com.xuni.entity.User;
import com.xuni.service.IUserService;
import com.xuni.utils.RSA;
import com.xuni.utils.SignMD5;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    private final String SALT = "xuni";
    @Resource
    private IUserService userService;

    @GetMapping("/login")
    public Result<User> login(HttpServletRequest request,
                              @RequestParam("username") String username,
                              @RequestParam("password") String passwdStr) {
        passwdStr = passwdStr.replaceAll(" ", "+");
        passwdStr = RSA.priDecode(passwdStr);
        String time = passwdStr.substring(passwdStr.length() - 13);
        if (System.currentTimeMillis() - Long.parseLong(time) > 1 * 60 * 1000) {
            return Result.fail("登录异常，时间超时");
        }

        String password = passwdStr.substring(0, passwdStr.length() - 13);
        return userService.login(request.getSession(), username, password);
    }

    @PostMapping("/logout")
    public Result<Object> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("identity");
        return Result.success();
    }

    @PostMapping("/register")
    public Result<User> register(@RequestParam String username, @RequestParam String password) {
        return userService.register(username, password);
    }

    @PostMapping("/recharge")
    public Result<Object> recharge(@RequestParam String username,
                                   @RequestParam Float money,
                                   @RequestParam String sign) {
        String str = "username=" + username + "&money=" + money.intValue() + "&salt=" + SALT;
        System.out.println(str);
        String md5 = SignMD5.getMD5(str);
        if (!md5.equals(sign)) {
            return Result.fail("接口被篡改");
        }
        return userService.recharge(username, money);
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
