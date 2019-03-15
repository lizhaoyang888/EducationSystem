package com.lizhaoyang.studentservice.domain;

import lombok.Data;

/**
 * @Author: lichaoyang
 * @Date: 2019-02-27 12:58
 */

@Data
public class Student {
    private int id;
    private String name;
    private String password;
    private int sex;
    private String grade;
    private String clazz;
}
