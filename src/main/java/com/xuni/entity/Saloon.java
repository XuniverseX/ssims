package com.xuni.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xuni
 * @since 2022-07-02
 */
@Data
@TableName("saloon")
public class Saloon implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sno", type = IdType.AUTO)
    private Long sno;
    /**
     * 轿车型号
     */
    private String model;
    /**
     * 轿车颜色
     */
    private String color;
    /**
     * 轿车生产厂家
     */
    private String manufacturer;
    /**
     * 轿车生产日期
     */
    private LocalDateTime createDate;
    /**
     * 轿车价格
     */
    private Float price;

}
