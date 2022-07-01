package com.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.dto.Result;
import com.common.entity.SaloonSales;

import java.util.List;

public interface ISaloonSalesService extends IService<SaloonSales> {
    Result<List<SaloonSales>> getAll(Integer current);
}
