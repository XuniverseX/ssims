package com.xuni.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xuni
 * @since 2022-07-02
 */
@Data
@TableName("customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cno", type = IdType.AUTO)
    private Long cno;
    /**
     * 客户姓名
     */
    private String name;
    /**
     * 客户电话
     */
    private String phone;
    /**
     * 客户住址
     */
    private String address;
    /**
     * 业务联系记录
     */
    private String record;
}
