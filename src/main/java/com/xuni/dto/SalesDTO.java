package com.xuni.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SalesDTO {
    private Long id;
    private LocalDateTime salesDate;
    private String saloonModel;
    private String employeeName;
    private String customerName;
    private String customerPhone;
    private Double saloonPrice;
}
