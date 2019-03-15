package com.lizhaoyang.springcloudfeign.service;

import com.lizhaoyang.springcloudfeign.domain.Student;
import com.lizhaoyang.springcloudfeign.hystrix.FeignStudentServiceHystrix;
import com.lizhaoyang.springcloudfeign.util.RestResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-03-04 14:09
 */

@FeignClient(value = "STUDENT",fallback = FeignStudentServiceHystrix.class)
public interface FeignStudentService {
    @RequestMapping(value = "/test/hello",method = RequestMethod.GET)
    String test();

    @RequestMapping(value = "/student/find/all",method = RequestMethod.GET)
    RestResult<List<Student>> findAll();
}
