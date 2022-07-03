package com.common.controller;

import com.common.dto.PreSelectDTO;
import com.common.dto.SalesDTO;
import com.common.dto.SaloonSalesDTO;
import com.common.entity.SaloonSales;
import com.common.service.ISaloonSalesService;
import com.common.dto.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sales")
public class SaloonSalesController {

    @Resource
    private ISaloonSalesService saloonSalesService;

    @PostMapping
    public Result<Object> save(@RequestBody SaloonSales saloonSales) {
        boolean success = saloonSalesService.save(saloonSales);
        if (!success) {
            return Result.fail("保存失败");
        }
        return Result.success();
    }

    @PostMapping("/getAll")
    public Result<SalesDTO> getAll(@RequestParam(value = "current", defaultValue = "1") Integer current,
                                   @RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize,
                                   @RequestBody PreSelectDTO preSelectDTO) {
        return saloonSalesService.getAll(current, pageSize, preSelectDTO);
    }

}
