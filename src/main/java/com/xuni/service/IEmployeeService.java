package com.xuni.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuni.dto.PageDTO;
import com.xuni.dto.Result;
import com.xuni.entity.Employee;

public interface IEmployeeService extends IService<Employee> {
    Result<PageDTO<Employee>> getAll(Integer current, Integer pageSize);
}
