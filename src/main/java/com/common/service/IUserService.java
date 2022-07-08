package com.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.dto.PageDTO;
import com.common.dto.Result;
import com.common.entity.User;

import javax.servlet.http.HttpSession;

public interface IUserService extends IService<User> {
    Result<User> login(HttpSession session, String username, String password);

    Result<User> register(String username, String password);

    Result<PageDTO<User>> getAll(Integer current, Integer pageSize);
}
