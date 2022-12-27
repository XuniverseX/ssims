package com.xuni.controller;

import com.xuni.dto.PageDTO;
import com.xuni.dto.Result;
import com.xuni.entity.Saloon;
import com.xuni.service.ISaloonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/saloon")
public class SaloonController {

    @Resource
    private ISaloonService saloonService;

    @GetMapping
    public Result<PageDTO<Saloon>> getAll(@RequestParam(value = "current", defaultValue = "1") Integer current,
                                          @RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize) {
        return saloonService.getAll(current, pageSize);
    }

    @GetMapping("/{id}")
    public Result<Saloon> getSaloonById(@PathVariable Long id) {
        Saloon saloon = saloonService.getById(id);
        if (saloon == null) {
            return Result.fail("未查询到该汽车");
        }
        return Result.success(saloon);
    }

    @PostMapping
    public Result<Object> saveSaloon(@RequestBody Saloon saloon) {
        boolean success = saloonService.save(saloon);
        if (!success) {
            return Result.fail("保存失败");
        }
        return Result.success();
    }

    @PutMapping
    public Result<Object> updateSaloonById(@RequestBody Saloon saloon) {
        if (!saloonService.updateById(saloon)) {
            return Result.fail("更新失败");
        }
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<Object> deleteSaloonById(@PathVariable Long id) {
        if (!saloonService.removeById(id)) {
            return Result.fail("删除失败");
        }
        return Result.success();
    }

}
