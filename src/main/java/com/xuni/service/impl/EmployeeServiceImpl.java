package com.xuni.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuni.dto.PageDTO;
import com.xuni.dto.Result;
import com.xuni.entity.Employee;
import com.xuni.mapper.EmployeeMapper;
import com.xuni.service.IEmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {
    @Override
    public Result<PageDTO<Employee>> getAll(Integer current, Integer pageSize) {
        Page<Employee> page = query().page(new Page<>(current, pageSize));
        PageDTO<Employee> pageDTO = new PageDTO<>();
        pageDTO.setList(page.getRecords());
        pageDTO.setPages(page.getPages());
        pageDTO.setTotalCount(page.getTotal());
        return Result.success(pageDTO);
    }
}
