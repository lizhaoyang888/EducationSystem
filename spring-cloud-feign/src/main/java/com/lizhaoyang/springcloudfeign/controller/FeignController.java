package com.lizhaoyang.springcloudfeign.controller;

import com.lizhaoyang.springcloudfeign.domain.Course;
import com.lizhaoyang.springcloudfeign.domain.CourseManagement;
import com.lizhaoyang.springcloudfeign.domain.Student;
import com.lizhaoyang.springcloudfeign.domain.Teacher;
import com.lizhaoyang.springcloudfeign.service.FeignCourseService;
import com.lizhaoyang.springcloudfeign.service.FeignStudentService;
import com.lizhaoyang.springcloudfeign.service.FeignTeacherService;
import com.lizhaoyang.springcloudfeign.util.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-03-04 14:13
 */
@RestController
@RequestMapping(value = "feign/")
public class FeignController {

    @Autowired
    private FeignStudentService feignStudentService;

    @Autowired
    private FeignTeacherService feignTeacherService;

    @Autowired
    private FeignCourseService feignCourseService;

    @RequestMapping(value = "student/test",method = RequestMethod.GET)
    public String stu_test(){
        return feignStudentService.test();
    }

    @RequestMapping(value = "student/all",method = RequestMethod.GET)
    public RestResult<List<Student>> stu_all(){
        return feignStudentService.findAll();
    }

    @RequestMapping(value = "teacher/test",method = RequestMethod.GET)
    public String tea_test(){
        return feignTeacherService.test();
    }

    @RequestMapping(value = "teacher/all",method = RequestMethod.GET)
    public RestResult<List<Teacher>> tea_all(){
        return feignTeacherService.findAll();
    }

    @RequestMapping(value = "course/test",method = RequestMethod.GET)
    public String course_test(){
        return feignCourseService.test();
    }

    @RequestMapping(value = "course/all",method = RequestMethod.GET)
    public RestResult<List<Course>> course_all(){
        return feignCourseService.findCourseAll();
    }

    @RequestMapping(value = "coursemanagement/all",method = RequestMethod.GET)
    public RestResult<List<CourseManagement>> courseMan_all(){
        return feignCourseService.findCourseManagementAll();
    }

    @RequestMapping(value = "coursemanagement/add",method = RequestMethod.POST)
    public RestResult<String> addCourseManagement(@RequestBody CourseManagement courseManagement){
        return feignCourseService.addCourseManagement(courseManagement);
    }

    @RequestMapping(value = "coursemanagement/delete",method = RequestMethod.POST)
    public RestResult<String> delete(@RequestBody CourseManagement courseManagement){
        return feignCourseService.delete(courseManagement);
    }
}
