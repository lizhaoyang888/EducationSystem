package com.lizhaoyang.courseservice.domain;

import lombok.Data;

/**
 * @Author: lichaoyang
 * @Date: 2019-02-27 12:58
 */

@Data
public class Course {
    private int id;
    private String name;
    private int credit;
    private int type;
    private String teacher;
    private int section;
    private String interval;
    private String room;
    private int total;
    private int rest;
}
