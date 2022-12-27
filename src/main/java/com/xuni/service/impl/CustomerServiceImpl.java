package com.xuni.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuni.dto.PageDTO;
import com.xuni.dto.Result;
import com.xuni.entity.Customer;
import com.xuni.mapper.CustomerMapper;
import com.xuni.service.ICustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Override
    public Result<PageDTO<Customer>> getAll(Integer current, Integer pageSize) {
        Page<Customer> page = query().page(new Page<>(current, pageSize));
        PageDTO<Customer> pageDTO = new PageDTO<>();
        pageDTO.setList(page.getRecords());
        pageDTO.setPages(page.getPages());
        pageDTO.setTotalCount(page.getTotal());
        return Result.success(pageDTO);
    }

}
