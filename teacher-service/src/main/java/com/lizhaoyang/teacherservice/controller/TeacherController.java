package com.lizhaoyang.teacherservice.controller;

import com.lizhaoyang.teacherservice.domain.Teacher;
import com.lizhaoyang.teacherservice.service.TeacherService;
import com.lizhaoyang.teacherservice.util.RestResult;
import com.lizhaoyang.teacherservice.util.RestResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-02-28 12:20
 */

@RestController
@RequestMapping(value = "teacher/")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public RestResult<Teacher> login(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id").trim());
        String password = request.getParameter("password").trim();
        Teacher teacher = teacherService.login(id,password);
        if (teacher != null){
            return RestResultGenerator.createSuccessResult(teacher);
        }else {
            return RestResultGenerator.createFailResult(404,"账号有误");
        }
    }

    @RequestMapping(value = "find/{id}",method = RequestMethod.GET)
    public RestResult<Teacher> findById(@PathVariable("id")int id){
        Teacher teacher = teacherService.findById(id);
        if (teacher != null){
            return RestResultGenerator.createSuccessResult(teacher);
        }else {
            return RestResultGenerator.createFailResult(500,"找不到对应id的教师");
        }
    }

    @RequestMapping(value = "find/all",method = RequestMethod.GET)
    public RestResult<List<Teacher>> findAll(){
        List<Teacher> teachers = teacherService.findAll();
        if (teachers != null){
            return RestResultGenerator.createSuccessResult(teachers);
        }else {
            return RestResultGenerator.createFailResult(500,"暂时还没有教师");
        }
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public RestResult<String> register(@RequestBody Teacher teacher){
        int code = teacherService.addTeacher(teacher);
        if (code == 1){
            return RestResultGenerator.createSuccessResult("注册成功");
        }else {
            return RestResultGenerator.createFailResult(500,"注册失败");
        }
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public RestResult<String> delete(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id").trim());
        int code = teacherService.deleteById(id);
        if (code == 1){
            return RestResultGenerator.createSuccessResult("删除成功");
        }else {
            return RestResultGenerator.createFailResult(500,"删除失败");
        }
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public RestResult<String> update(@RequestBody Teacher teacher){
        int code = teacherService.updateTeacher(teacher);
        if (code == 1){
            return RestResultGenerator.createSuccessResult("修改成功");
        }else {
            return RestResultGenerator.createFailResult(500,"修改失败");
        }
    }

}
