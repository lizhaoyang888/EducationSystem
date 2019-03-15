package com.lizhaoyang.studentservice.util;

import lombok.Data;

/**
 * @Author: lichaoyang
 * @Date: 2019-02-27 13:44
 */
@Data
public class RestResult<T> {

    private int code;
    private String message;
    private T data;

    public RestResult() {
    }

    RestResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
