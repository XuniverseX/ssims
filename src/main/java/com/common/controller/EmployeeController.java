package com.common.controller;

import com.common.dto.Result;
import com.common.entity.Employee;
import com.common.service.IEmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private IEmployeeService employeeService;

    @PostMapping
    public Result<Object> save(@RequestBody Employee employee) {
        boolean success = employeeService.save(employee);
        if (!success) {
            return Result.fail("保存失败");
        }
        return Result.success();
    }

}
