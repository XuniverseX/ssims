package com.common.entity;

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
@TableName("employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "eno", type = IdType.AUTO)
    private Long id;
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 员工性别
     */
    private String sex;
    /**
     * 员工年龄
     */
    private Integer age;
    /**
     * 员工籍贯
     */
    private String nativePlace;
    /**
     * 员工学历
     */
    private String education;
}
