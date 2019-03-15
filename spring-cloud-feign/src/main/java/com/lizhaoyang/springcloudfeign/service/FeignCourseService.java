package com.lizhaoyang.springcloudfeign.service;

import com.lizhaoyang.springcloudfeign.domain.Course;
import com.lizhaoyang.springcloudfeign.domain.CourseManagement;
import com.lizhaoyang.springcloudfeign.hystrix.FeignCourseServiceHystrix;
import com.lizhaoyang.springcloudfeign.util.RestResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-03-04 14:09
 */

@FeignClient(value = "COURSE",fallback = FeignCourseServiceHystrix.class)
public interface FeignCourseService {
    @RequestMapping(value = "/test/hello",method = RequestMethod.GET)
    String test();

    @RequestMapping(value = "/course/find/all",method = RequestMethod.GET)
    RestResult<List<Course>> findCourseAll();

    @RequestMapping(value = "/coursemanagement/find/all",method = RequestMethod.GET)
    RestResult<List<CourseManagement>> findCourseManagementAll();

    @RequestMapping(value = "/coursemanagement/add",method = RequestMethod.POST)
    RestResult<String> addCourseManagement(CourseManagement courseManagement);

    @RequestMapping(value = "/coursemanagement/delete",method = RequestMethod.POST)
    RestResult<String> delete(CourseManagement courseManagement);
}
