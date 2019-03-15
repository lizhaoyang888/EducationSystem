package com.lizhaoyang.courseservice.controller;

import com.lizhaoyang.courseservice.domain.CourseManagement;
import com.lizhaoyang.courseservice.exception.AddCourseManagementFaildException;
import com.lizhaoyang.courseservice.exception.DelCourseManagementFaildException;
import com.lizhaoyang.courseservice.service.CourseManagementService;
import com.lizhaoyang.courseservice.util.RestResult;
import com.lizhaoyang.courseservice.util.RestResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-02-28 12:19
 */

@RestController
@RequestMapping(value = "coursemanagement/")
public class CourseManagementController {

    @Autowired
    private CourseManagementService courseManagementService;

    @RequestMapping(value = "find/all",method = RequestMethod.GET)
    public RestResult<List<CourseManagement>> findAll(){
        List<CourseManagement> courseManagements = courseManagementService.findAll();
        if (courseManagements != null){
            return RestResultGenerator.createSuccessResult(courseManagements);
        }else {
            return RestResultGenerator.createFailResult(500,"服务器错误");
        }
    }

    @RequestMapping(value = "find/id/{id}",method = RequestMethod.GET)
    public RestResult<CourseManagement> findById(@PathVariable("id")int id){
        CourseManagement courseManagement = courseManagementService.findById(id);
        if (courseManagement != null){
            return RestResultGenerator.createSuccessResult(courseManagement);
        }else {
            return RestResultGenerator.createFailResult(500,"服务器错误");
        }
    }

    @RequestMapping(value = "find/studentId/{studentId}",method = RequestMethod.GET)
    public RestResult<List<CourseManagement>> findByStudentId(@PathVariable("studentId") int studentId){
        List<CourseManagement> courseManagements = courseManagementService.findByStudentId(studentId);
        if (courseManagements != null){
            return RestResultGenerator.createSuccessResult(courseManagements);
        }else {
            return RestResultGenerator.createFailResult(500,"服务器错误");
        }
    }

    @RequestMapping(value = "find/courseId/{courseId}",method = RequestMethod.GET)
    public RestResult<List<CourseManagement>> findByCourseId(@PathVariable("courseId") int courseId){
        List<CourseManagement> courseManagements = courseManagementService.findByCourseId(courseId);
        if (courseManagements != null){
            return RestResultGenerator.createSuccessResult(courseManagements);
        }else {
            return RestResultGenerator.createFailResult(500,"服务器错误");
        }
    }

    /**
     * 选课
     * @param courseManagement
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public RestResult<String> add(@RequestBody CourseManagement courseManagement){
        try {
            int code = courseManagementService.addCourseManagement(courseManagement);
        }catch (AddCourseManagementFaildException e){
            return RestResultGenerator.createFailResult(500,e.getMessage());
        }
        return RestResultGenerator.createSuccessResult("选课成功");
    }

    /**
     * 退选
     * @param courseManagement
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public RestResult<String> delete(@RequestBody CourseManagement courseManagement){
        try {
            int code = courseManagementService.delCourseManagement(courseManagement);
        }catch (DelCourseManagementFaildException e){
            return RestResultGenerator.createFailResult(500,e.getMessage());
        }
        return RestResultGenerator.createSuccessResult("删除成功");
    }

}
