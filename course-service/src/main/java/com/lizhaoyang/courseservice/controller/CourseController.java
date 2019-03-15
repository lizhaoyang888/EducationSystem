package com.lizhaoyang.courseservice.controller;

import com.lizhaoyang.courseservice.domain.Course;
import com.lizhaoyang.courseservice.service.CourseService;
import com.lizhaoyang.courseservice.util.RestResult;
import com.lizhaoyang.courseservice.util.RestResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-02-28 12:19
 */

@RestController
@RequestMapping(value = "course/")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "find/all",method = RequestMethod.GET)
    public RestResult<List<Course>> findAll(){
        List<Course> courses = courseService.findAll();
        if (courses != null){
            return RestResultGenerator.createSuccessResult(courses);
        }else {
            return RestResultGenerator.createFailResult(500,"服务器错误");
        }
    }

    @RequestMapping(value = "find/id/{id}",method = RequestMethod.GET)
    public RestResult<Course> findById(@PathVariable("id")int id){
        Course course = courseService.findById(id);
        if (course != null){
            return RestResultGenerator.createSuccessResult(course);
        }else {
            return RestResultGenerator.createFailResult(500,"服务器错误");
        }
    }

    @RequestMapping(value = "find/type/{type}",method = RequestMethod.GET)
    public RestResult<List<Course>> findByType(@PathVariable("type")int type){
        List<Course> courses = courseService.findByType(type);
        if (courses != null){
            return RestResultGenerator.createSuccessResult(courses);
        }else {
            return RestResultGenerator.createFailResult(500,"服务器错误");
        }
    }

    @RequestMapping(value = "find/teacher/{teacher}",method = RequestMethod.GET)
    public RestResult<List<Course>> findByTeacher(@PathVariable("teacher")String teacher){
        List<Course> courses = courseService.findByTeacher(teacher);
        if (courses != null){
            return RestResultGenerator.createSuccessResult(courses);
        }else {
            return RestResultGenerator.createFailResult(500,"服务器错误");
        }
    }

    @RequestMapping(value = "find/rest",method = RequestMethod.GET)
    public RestResult<List<Course>> findByRest(){
        List<Course> courses = courseService.findByRest();
        if (courses != null){
            return RestResultGenerator.createSuccessResult(courses);
        }else {
            return RestResultGenerator.createFailResult(500,"服务器错误");
        }
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public RestResult<String> add(@RequestBody Course course){
        int code = courseService.addCourse(course);
        if (code == 1){
            return RestResultGenerator.createSuccessResult("添加成功");
        }else {
            return RestResultGenerator.createFailResult(500,"添加失败");
        }
    }

    @RequestMapping(value = "delete/{id}",method = RequestMethod.POST)
    public RestResult<String> delete(@PathVariable("id")int id){
        int code = courseService.deleteById(id);
        if (code == 1){
            return RestResultGenerator.createSuccessResult("删除成功");
        }else {
            return RestResultGenerator.createFailResult(500,"删除失败");
        }
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public RestResult<String> update(@RequestBody Course course){
        int code = courseService.updateCourse(course);
        if (code == 1){
            return RestResultGenerator.createSuccessResult("修改成功");
        }else {
            return RestResultGenerator.createFailResult(500,"修改失败");
        }
    }


}
