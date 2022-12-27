package com.xuni.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuni.dto.PageDTO;
import com.xuni.dto.Result;
import com.xuni.entity.Saloon;

public interface ISaloonService extends IService<Saloon> {
    Result<PageDTO<Saloon>> getAll(Integer current, Integer pageSize);
}
