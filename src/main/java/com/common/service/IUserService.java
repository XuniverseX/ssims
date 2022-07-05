package com.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.dto.Result;
import com.common.entity.User;

public interface IUserService extends IService<User> {
    Result<User> login(String username, String password);

    Result<User> register(String username, String password);
}
