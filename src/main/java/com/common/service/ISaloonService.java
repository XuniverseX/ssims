package com.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.dto.PageDTO;
import com.common.dto.Result;
import com.common.entity.Saloon;

public interface ISaloonService extends IService<Saloon> {
    Result<PageDTO<Saloon>> getAll(Integer current, Integer pageSize);
}
