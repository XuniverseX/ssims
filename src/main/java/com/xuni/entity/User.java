package com.xuni.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xuni
 * @since 2022-07-04
 */
@Data
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "uno", type = IdType.AUTO)
    private Integer uno;

    private String username;

    private String password;

    private Boolean isAuth;

    private Float money;
}
