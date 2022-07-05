package com.common.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageDTO<T> {
    private List<T> list;
    private long pages;
    private long totalCount;
}
