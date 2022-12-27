package com.xuni.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuni.dto.PageDTO;
import com.xuni.dto.Result;
import com.xuni.entity.Customer;

public interface ICustomerService extends IService<Customer> {
    Result<PageDTO<Customer>> getAll(Integer current, Integer pageSize);
}
