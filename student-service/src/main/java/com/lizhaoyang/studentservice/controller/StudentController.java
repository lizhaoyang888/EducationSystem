package com.lizhaoyang.studentservice.controller;


import com.lizhaoyang.studentservice.domain.Student;
import com.lizhaoyang.studentservice.service.StudentService;
import com.lizhaoyang.studentservice.util.RestResult;
import com.lizhaoyang.studentservice.util.RestResultGenerator;
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
@RequestMapping(value = "student/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public RestResult<Student> login(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id").trim());
        String password = request.getParameter("password").trim();
        Student student = studentService.login(id,password);
        if (student != null){
            return RestResultGenerator.createSuccessResult(student);
        }else {
            return RestResultGenerator.createFailResult(500,"账号有误");
        }
    }

    @RequestMapping(value = "find/{id}",method = RequestMethod.GET)
    public RestResult<Student> findById(@PathVariable("id")int id){
        Student student = studentService.findById(id);
        if (student != null){
            return RestResultGenerator.createSuccessResult(student);
        }else {
            return RestResultGenerator.createFailResult(500,"找不到对应id的学生");
        }
    }

    @RequestMapping(value = "find/all",method = RequestMethod.GET)
    public RestResult<List<Student>> findAll(){
        List<Student> students = studentService.findAll();
        if (students != null){
            return RestResultGenerator.createSuccessResult(students);
        }else {
            return RestResultGenerator.createFailResult(500,"暂时还没有学生");
        }
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public RestResult<String> register(@RequestBody Student student){
        int code = studentService.addStudent(student);
        if (code == 1){
            return RestResultGenerator.createSuccessResult("注册成功");
        }else {
            return RestResultGenerator.createFailResult(500,"注册失败");
        }
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public RestResult<String> delete(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id").trim());
        int code = studentService.deleteById(id);
        if (code == 1){
            return RestResultGenerator.createSuccessResult("删除成功");
        }else {
            return RestResultGenerator.createFailResult(500,"删除失败");
        }
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public RestResult<String> update(@RequestBody Student student){
        int code = studentService.updateStudent(student);
        if (code == 1){
            return RestResultGenerator.createSuccessResult("修改成功");
        }else {
            return RestResultGenerator.createFailResult(500,"修改失败");
        }
    }


}
