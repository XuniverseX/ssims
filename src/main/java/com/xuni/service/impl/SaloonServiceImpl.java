package com.xuni.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuni.dto.PageDTO;
import com.xuni.dto.Result;
import com.xuni.entity.Saloon;
import com.xuni.mapper.SaloonMapper;
import com.xuni.service.ISaloonService;
import org.springframework.stereotype.Service;

@Service
public class SaloonServiceImpl extends ServiceImpl<SaloonMapper, Saloon> implements ISaloonService {
    @Override
    public Result<PageDTO<Saloon>> getAll(Integer current, Integer pageSize) {
        Page<Saloon> page = query().page(new Page<>(current, pageSize));
        PageDTO<Saloon> pageDTO = new PageDTO<>();
        pageDTO.setList(page.getRecords());
        pageDTO.setPages(page.getPages());
        pageDTO.setTotalCount(page.getTotal());
        return Result.success(pageDTO);
    }
}
