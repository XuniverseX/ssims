package com.common.dto;

import com.common.entity.SaloonSales;
import lombok.Data;

import java.util.List;

@Data
public class SalesDTO {
    private List<SaloonSales> list;
    private long pages;
    private long totalCount;
}
