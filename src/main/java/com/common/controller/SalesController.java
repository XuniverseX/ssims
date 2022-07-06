package com.common.controller;

import com.common.dto.PreSelectDTO;
import com.common.dto.PageDTO;
import com.common.dto.SalesDTO;
import com.common.entity.Sales;
import com.common.service.ISalesService;
import com.common.dto.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Resource
    private ISalesService salesService;

    @PostMapping("/data")
    public Result<PageDTO<SalesDTO>> getDisplayData(@RequestParam(value = "current", defaultValue = "1") Integer current,
                                                    @RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize,
                                                    @RequestBody PreSelectDTO preSelectDTO) {
        return salesService.getDisplayData(current, pageSize, preSelectDTO);
    }

    @GetMapping
    public Result<PageDTO<Sales>> getAll(@RequestParam(value = "current", defaultValue = "1") Integer current,
                                         @RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize) {
        return salesService.getAll(current, pageSize);
    }

    @GetMapping("/{id}")
    public Result<Sales> getSalesById(@PathVariable Long id) {
        Sales sales = salesService.getById(id);
        if (sales == null) {
            return Result.fail("未查询到该订单");
        }
        return Result.success(sales);
    }

    @DeleteMapping("/{id}")
    public Result<Object> deleteSalesById(@PathVariable Long id) {
        if (!salesService.removeById(id)) {
            return Result.fail("删除失败");
        }
        return Result.success();
    }

    @PutMapping
    public Result<Object> updateSalesById(@RequestBody Sales sales) {
        if (!salesService.updateById(sales)) {
            return Result.fail("更新失败");
        }
        return Result.success();
    }

    @PostMapping
    public Result<Object> saveSales(@RequestBody Sales sales) {
        boolean success = salesService.save(sales);
        if (!success) {
            return Result.fail("保存失败");
        }
        return Result.success();
    }

}
