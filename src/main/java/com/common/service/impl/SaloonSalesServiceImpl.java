package com.common.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.dto.PreSelectDTO;
import com.common.dto.Result;
import com.common.dto.SalesDTO;
import com.common.dto.SaloonSalesDTO;
import com.common.entity.Customer;
import com.common.entity.Employee;
import com.common.entity.Saloon;
import com.common.entity.SaloonSales;
import com.common.mapper.SaloonSalesMapper;
import com.common.service.ICustomerService;
import com.common.service.IEmployeeService;
import com.common.service.ISaloonSalesService;
import com.common.service.ISaloonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaloonSalesServiceImpl extends ServiceImpl<SaloonSalesMapper, SaloonSales> implements ISaloonSalesService {

    @Resource
    private ISaloonService saloonService;

    @Resource
    private ICustomerService customerService;

    @Resource
    private IEmployeeService employeeService;

    @Override
    public Result<SalesDTO> getAll(Integer current, Integer pageSize, PreSelectDTO preSelectDTO) {
        Page<SaloonSales> page = query()
                .page(new Page<>(current, pageSize));

        List<SaloonSalesDTO> result = new ArrayList<>();

        page.getRecords().forEach(saloonSales -> {
            SaloonSalesDTO temp = new SaloonSalesDTO();
            Saloon saloon = saloonService.query().eq("id", saloonSales.getSaloonId()).one();
            Employee employee = employeeService.query().eq("id", saloonSales.getEmployeeId()).one();
            Customer customer = customerService.query().eq("id", saloonSales.getCustomerId()).one();


            if (!preSelectDTO.getSaloonModel().isEmpty())
                if (!saloon.getModel().equals(preSelectDTO.getSaloonModel()))
                    return;

            if (!preSelectDTO.getCustomerName().isEmpty())
                if (!customer.getName().equals(preSelectDTO.getCustomerName()))
                    return;

            if (!preSelectDTO.getEmployeeName().isEmpty())
                if (!employee.getName().equals(preSelectDTO.getEmployeeName()))
                    return;

            temp.setId(saloonSales.getId());
            temp.setSalesDate(saloonSales.getSalesDate());
            temp.setSaloonModel(saloon.getModel());
            temp.setCustomerName(customer.getName());
            temp.setEmployeeName(employee.getName());
            temp.setCustomerPhone(customer.getPhone());
            temp.setSaloonPrice(saloon.getPrice());

            result.add(temp);
        });

        SalesDTO salesDTO = new SalesDTO();
        salesDTO.setList(result);
        salesDTO.setPages(page.getPages());
        salesDTO.setTotalCount(page.getTotal());
        return Result.success(salesDTO);
    }
}
