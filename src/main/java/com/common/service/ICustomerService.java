package com.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.dto.PageDTO;
import com.common.dto.Result;
import com.common.entity.Customer;

public interface ICustomerService extends IService<Customer> {
    Result<PageDTO<Customer>> getAll(Integer current, Integer pageSize);
}
