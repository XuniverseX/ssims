package com.common.controller;

import com.common.dto.Result;
import com.common.entity.Saloon;
import com.common.service.ISaloonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/saloon")
public class SaloonController {

    @Resource
    private ISaloonService saloonService;

    @PostMapping
    public Result<Object> save(@RequestBody Saloon saloon) {
        boolean success = saloonService.save(saloon);
        if (!success) {
            return Result.fail("保存失败");
        }
        return Result.success();
    }

}
