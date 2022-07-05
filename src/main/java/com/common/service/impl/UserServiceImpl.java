package com.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.dto.Result;
import com.common.entity.User;
import com.common.mapper.UserMapper;
import com.common.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public Result<User> login(String username, String password) {
        User user = query().eq("username", username).eq("password", password).one();
        if (user == null) {
            return Result.fail("没有此用户，请重新登录");
        }
        return Result.success(user);
    }

    @Override
    public Result<User> register(String username, String password) {
        User user = query().eq("username", username).eq("password", password).one();
        if (user != null) {
            return Result.fail("创建失败,用户已存在");
        }
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        save(newUser);
        return Result.success(newUser);
    }
}
