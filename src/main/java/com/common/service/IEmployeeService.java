package com.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.dto.PageDTO;
import com.common.dto.Result;
import com.common.entity.Employee;

public interface IEmployeeService extends IService<Employee> {
    Result<PageDTO<Employee>> getAll(Integer current, Integer pageSize);
}
