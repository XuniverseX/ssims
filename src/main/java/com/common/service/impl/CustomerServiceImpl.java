package com.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.entity.Customer;
import com.common.mapper.CustomerMapper;
import com.common.service.ICustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {
}
