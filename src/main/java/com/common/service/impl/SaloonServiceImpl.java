package com.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.entity.Saloon;
import com.common.mapper.SaloonMapper;
import com.common.service.ISaloonService;
import org.springframework.stereotype.Service;

@Service
public class SaloonServiceImpl extends ServiceImpl<SaloonMapper, Saloon> implements ISaloonService {
}
