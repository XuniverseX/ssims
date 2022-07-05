package com.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.dto.PreSelectDTO;
import com.common.dto.Result;
import com.common.dto.PageDTO;
import com.common.dto.SalesDTO;
import com.common.entity.Sales;

public interface ISalesService extends IService<Sales> {
    Result<PageDTO<SalesDTO>> getAll(Integer current, Integer pageSize, PreSelectDTO preSelectDTO);
}
