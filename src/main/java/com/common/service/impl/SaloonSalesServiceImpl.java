package com.common.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.dto.Result;
import com.common.entity.SaloonSales;
import com.common.mapper.SaloonSalesMapper;
import com.common.service.ISaloonSalesService;
import com.common.utils.SystemConstants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaloonSalesServiceImpl extends ServiceImpl<SaloonSalesMapper, SaloonSales> implements ISaloonSalesService {
    @Override
    public Result<List<SaloonSales>> getAll(Integer current) {
        Page<SaloonSales> page = query()
                .page(new Page<>(current, SystemConstants.MAX_PAGE_SIZE));
        List<SaloonSales> records = page.getRecords();
        return Result.success(records);
    }
}
