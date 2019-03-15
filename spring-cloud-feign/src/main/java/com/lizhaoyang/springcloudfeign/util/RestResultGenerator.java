package com.lizhaoyang.springcloudfeign.util;

/**
 * @Author: lichaoyang
 * @Date: 2019-02-27 13:43
 */
public class RestResultGenerator {

    public RestResultGenerator() {
    }

    public static <T> RestResult<T> createRestResult(int code, String message, T data) {
        return new RestResult(code, message, data);
    }

    public static <T> RestResult<T> createSuccessResult(T data) {
        return new RestResult(1000, "成功", data);
    }

    public static RestResult createFailResult(int code, String message) {
        return new RestResult(code, message, (Object)null);
    }
}
