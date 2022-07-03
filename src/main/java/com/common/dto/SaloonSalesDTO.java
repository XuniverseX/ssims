package com.common.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SaloonSalesDTO {
    private Long id;
    private LocalDateTime salesDate;
    private String saloonModel;
    private String employeeName;
    private String customerName;
    private String customerPhone;
    private Integer saloonPrice;
}
