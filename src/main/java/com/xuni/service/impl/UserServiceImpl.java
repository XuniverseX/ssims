package com.xuni.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuni.dto.PageDTO;
import com.xuni.dto.Result;
import com.xuni.entity.User;
import com.xuni.mapper.UserMapper;
import com.xuni.service.IUserService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public Result<User> login(HttpSession session, String username, String password) {
        User user = query().eq("username", username).eq("password", password).one();
        if (user == null) {
            return Result.fail("没有此用户，请重新登录");
        }
        session.setAttribute("identity", user.getIsAuth());
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

    @Override
    public Result<PageDTO<User>> getAll(Integer current, Integer pageSize) {
        Page<User> page = query().page(new Page<>(current, pageSize));
        PageDTO<User> pageDTO = new PageDTO<>();
        pageDTO.setList(page.getRecords());
        pageDTO.setPages(page.getPages());
        pageDTO.setTotalCount(page.getTotal());
        return Result.success(pageDTO);
    }
}
