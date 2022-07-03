package com.common.controller;

import com.common.dto.SalesDTO;
import com.common.service.ISaloonSalesService;
import com.common.dto.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("sales")
public class SaloonSalesController {

    @Resource
    private ISaloonSalesService saloonSalesService;

    @GetMapping
    public Result<SalesDTO> getAll(@RequestParam(value = "current", defaultValue = "1") Integer current,
                                   @RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize) {
        return saloonSalesService.getAll(current, pageSize);
    }

}
