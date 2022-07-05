package com.common.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.dto.PreSelectDTO;
import com.common.dto.Result;
import com.common.dto.PageDTO;
import com.common.dto.SalesDTO;
import com.common.entity.Customer;
import com.common.entity.Employee;
import com.common.entity.Sales;
import com.common.entity.Saloon;
import com.common.mapper.SalesMapper;
import com.common.service.ICustomerService;
import com.common.service.IEmployeeService;
import com.common.service.ISalesService;
import com.common.service.ISaloonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalesServiceImpl extends ServiceImpl<SalesMapper, Sales> implements ISalesService {

    @Resource
    private ISaloonService saloonService;

    @Resource
    private ICustomerService customerService;

    @Resource
    private IEmployeeService employeeService;

    @Override
    public Result<PageDTO<SalesDTO>> getAll(Integer current, Integer pageSize, PreSelectDTO preSelectDTO) {
        Page<Sales> page = query()
                .page(new Page<>(current, pageSize));

        List<SalesDTO> result = new ArrayList<>();

        page.getRecords().forEach(sales -> {
            SalesDTO temp = new SalesDTO();
            Saloon saloon = saloonService.query().eq("sno", sales.getSno()).one();
            Employee employee = employeeService.query().eq("eno", sales.getEno()).one();
            Customer customer = customerService.query().eq("cno", sales.getCno()).one();


            if (!preSelectDTO.getSaloonModel().isEmpty())
                if (!saloon.getModel().equals(preSelectDTO.getSaloonModel()))
                    return;

            if (!preSelectDTO.getCustomerName().isEmpty())
                if (!customer.getName().equals(preSelectDTO.getCustomerName()))
                    return;

            if (!preSelectDTO.getEmployeeName().isEmpty())
                if (!employee.getName().equals(preSelectDTO.getEmployeeName()))
                    return;

            temp.setId(sales.getId());
            temp.setSalesDate(sales.getSalesDate());
            temp.setSaloonModel(saloon.getModel());
            temp.setCustomerName(customer.getName());
            temp.setEmployeeName(employee.getName());
            temp.setCustomerPhone(customer.getPhone());
            temp.setSaloonPrice(saloon.getPrice());

            result.add(temp);
        });

        PageDTO<SalesDTO> pageDTO = new PageDTO<>();
        pageDTO.setList(result);
        pageDTO.setPages(page.getPages());
        pageDTO.setTotalCount(page.getTotal());
        return Result.success(pageDTO);
    }
}
