package com.common.entity;

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
@TableName("saloon_sales")
public class Sales implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 轿车id
     */
    private Long saloonId;
    /**
     * 员工id
     */
    private Long employeeId;
    /**
     * 客户id
     */
    private Long customerId;
    /**
     * 销售日期
     */
    private LocalDateTime salesDate;
}
