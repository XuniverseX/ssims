package com.xuni.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(0, null, data);
    }

    public static <T> Result<T> success() {
        return new Result<>(0, null, null);
    }

    public static <T> Result<T> fail(String msg) {
        return new Result<>(1, msg, null);
    }

}
