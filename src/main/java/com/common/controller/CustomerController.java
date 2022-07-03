package com.common.controller;

import com.common.dto.Result;
import com.common.entity.Customer;
import com.common.service.ICustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private ICustomerService customerService;

    @PostMapping
    public Result<Object> save(@RequestBody Customer customer) {
        boolean success = customerService.save(customer);
        if (!success) {
            return Result.fail("保存失败");
        }
        return Result.success();
    }

}
