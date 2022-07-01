package com.common.controller;

import com.common.entity.SaloonSales;
import com.common.service.ISaloonSalesService;
import com.common.dto.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("sales")
public class SaloonSalesController {

    @Resource
    private ISaloonSalesService saloonSalesService;

    @GetMapping
    public Result<List<SaloonSales>> getAll(@RequestParam(value = "current", defaultValue = "1") Integer current) {
        return saloonSalesService.getAll(current);
    }

}
