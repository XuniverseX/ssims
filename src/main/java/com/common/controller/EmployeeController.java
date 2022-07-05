package com.common.controller;

import com.common.dto.PageDTO;
import com.common.dto.Result;
import com.common.entity.Employee;
import com.common.service.IEmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private IEmployeeService employeeService;

    @GetMapping
    public Result<PageDTO<Employee>> getAll(@RequestParam(value = "current", defaultValue = "1") Integer current,
                                            @RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize) {
        return employeeService.getAll(current, pageSize);
    }

    @GetMapping("/{id}")
    public Result<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getById(id);
        if (employee == null) {
            return Result.fail("未查询到该员工");
        }
        return Result.success(employee);
    }

    @PostMapping
    public Result<Object> saveEmployee(@RequestBody Employee employee) {
        boolean success = employeeService.save(employee);
        if (!success) {
            return Result.fail("保存失败");
        }
        return Result.success();
    }

    @PutMapping
    public Result<Object> updateEmployeeById(@RequestBody Employee employee) {
        if (!employeeService.updateById(employee)) {
            return Result.fail("更新失败");
        }
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<Object> deleteEmployeeById(@PathVariable Long id) {
        if (!employeeService.removeById(id)) {
            return Result.fail("删除失败");
        }
        return Result.success();
    }

}
