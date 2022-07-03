package com.common.dto;

import lombok.Data;

import java.util.List;

@Data
public class SalesDTO {
    private List<SaloonSalesDTO> list;
    private long pages;
    private long totalCount;
}
