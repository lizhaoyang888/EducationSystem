package com.lizhaoyang.springcloudfeign.hystrix;

import com.lizhaoyang.springcloudfeign.domain.Course;
import com.lizhaoyang.springcloudfeign.domain.CourseManagement;
import com.lizhaoyang.springcloudfeign.domain.Student;
import com.lizhaoyang.springcloudfeign.service.FeignCourseService;
import com.lizhaoyang.springcloudfeign.service.FeignStudentService;
import com.lizhaoyang.springcloudfeign.util.RestResult;
import com.lizhaoyang.springcloudfeign.util.RestResultGenerator;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-03-04 14:32
 */

@Component
public class FeignCourseServiceHystrix implements FeignCourseService {

    private final static RestResult ERROR_RESULT = RestResultGenerator.createFailResult(500,"sorry,此服务因出错已熔断");

    @Override
    public String test() {
        return "sorry,此服务因出错已熔断";
    }

    @Override
    public RestResult<List<Course>> findCourseAll() {
        return ERROR_RESULT;
    }

    @Override
    public RestResult<List<CourseManagement>> findCourseManagementAll() {
        return ERROR_RESULT;
    }

    @Override
    public RestResult<String> addCourseManagement(CourseManagement courseManagement) {
        return ERROR_RESULT;
    }

    @Override
    public RestResult<String> delete(CourseManagement courseManagement) {
        return ERROR_RESULT;
    }
}
