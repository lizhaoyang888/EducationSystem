package com.lizhaoyang.teacherservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lichaoyang
 * @Date: 2019-03-02 10:48
 */

@RestController
@RequestMapping(value = "test")
//@RefreshScope
public class TestController {

//    @Value("${test}")
//    private String test;

    private String test = "hello world teacher";

    @RequestMapping(value = "/hello")
    public String test(){
        return test;
    }

}
