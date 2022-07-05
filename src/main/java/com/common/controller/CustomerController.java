package com.common.controller;

import com.common.dto.PageDTO;
import com.common.dto.Result;
import com.common.entity.Customer;
import com.common.service.ICustomerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private ICustomerService customerService;

    @GetMapping
    public Result<PageDTO<Customer>> getAll(@RequestParam(value = "current", defaultValue = "1") Integer current,
                                            @RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize) {
        return customerService.getAll(current, pageSize);
    }

    @GetMapping("/{id}")
    public Result<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getById(id);
        if (customer == null) {
            return Result.fail("未查询到该用户");
        }
        return Result.success(customer);
    }

    @PostMapping
    public Result<Object> saveCustomer(@RequestBody Customer customer) {
        boolean success = customerService.save(customer);
        if (!success) {
            return Result.fail("保存失败");
        }
        return Result.success();
    }

    @PutMapping
    public Result<Object> updateCustomerById(@RequestBody Customer customer) {
        if (!customerService.updateById(customer)) {
            return Result.fail("更新失败");
        }
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<Object> deleteCustomerById(@PathVariable Long id) {
        if (!customerService.removeById(id)) {
            return Result.fail("删除失败");
        }
        return Result.success();
    }

}
