package com.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.entity.Employee;
import com.common.mapper.EmployeeMapper;
import com.common.service.IEmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {
}
