package com.common.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.dto.PageDTO;
import com.common.dto.Result;
import com.common.entity.Employee;
import com.common.mapper.EmployeeMapper;
import com.common.service.IEmployeeService;
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
