package com.lizhaoyang.springcloudfeign.controller;//package com.lizhaoyang.springcloudribbon.controller;
//
//import com.lizhaoyang.springcloudribbon.domain.Student;
//import com.lizhaoyang.springcloudribbon.service.RibbonService;
//import com.lizhaoyang.springcloudribbon.util.RestResult;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * @Author: lichaoyang
// * @Date: 2019-03-04 12:48
// */
//
//@RestController
//@RequestMapping(value = "ribbon/")
//public class RibbonController {
//
//    @Autowired
//    private RibbonService ribbonService;
//
//    @RequestMapping(value = "all",method = RequestMethod.GET)
//    public RestResult<List<Student>> all(){
//        return ribbonService.student();
//    }
//
//    @RequestMapping(value = "test",method = RequestMethod.GET)
//    public String test(){
//        return ribbonService.test();
//    }
//}
