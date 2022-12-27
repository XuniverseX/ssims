package com.xuni.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuni.dto.PreSelectDTO;
import com.xuni.dto.Result;
import com.xuni.dto.PageDTO;
import com.xuni.dto.SalesDTO;
import com.xuni.entity.Sales;

public interface ISalesService extends IService<Sales> {
    Result<PageDTO<SalesDTO>> getDisplayData(Integer current, Integer pageSize, PreSelectDTO preSelectDTO);

    Result<PageDTO<Sales>> getAll(Integer current, Integer pageSize);
}
