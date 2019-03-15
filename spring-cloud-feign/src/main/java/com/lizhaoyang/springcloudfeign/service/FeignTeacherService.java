package com.lizhaoyang.springcloudfeign.service;

import com.lizhaoyang.springcloudfeign.domain.Teacher;
import com.lizhaoyang.springcloudfeign.hystrix.FeignTeacherServiceHystrix;
import com.lizhaoyang.springcloudfeign.util.RestResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-03-04 14:09
 */

@FeignClient(value = "TEACHER",fallback = FeignTeacherServiceHystrix.class)
public interface FeignTeacherService {
    @RequestMapping(value = "/test/hello",method = RequestMethod.GET)
    String test();

    @RequestMapping(value = "/teacher/find/all",method = RequestMethod.GET)
    RestResult<List<Teacher>> findAll();
}
