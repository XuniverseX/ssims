package com.xuni.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuni.dto.PageDTO;
import com.xuni.dto.Result;
import com.xuni.entity.User;

import javax.servlet.http.HttpSession;

public interface IUserService extends IService<User> {
    Result<User> login(HttpSession session, String username, String password);

    Result<User> register(String username, String password);

    Result<PageDTO<User>> getAll(Integer current, Integer pageSize);

    Result<Object> recharge(String username, Float money);
}
