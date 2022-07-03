package com.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.dto.Result;
import com.common.dto.SalesDTO;
import com.common.entity.SaloonSales;

public interface ISaloonSalesService extends IService<SaloonSales> {
    Result<SalesDTO> getAll(Integer current, Integer pageSize);
}
