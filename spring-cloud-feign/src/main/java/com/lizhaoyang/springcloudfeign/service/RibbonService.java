package com.lizhaoyang.springcloudfeign.service;//package com.lizhaoyang.springcloudribbon.service;
//
//import com.lizhaoyang.springcloudribbon.domain.Student;
//import com.lizhaoyang.springcloudribbon.util.RestResult;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author: lichaoyang
// * @Date: 2019-03-03 14:08
// */
//
//@Service
//public class RibbonService {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    public RestResult<List<Student>> student(){
//        RestResult<List<Student>> restResult = restTemplate.getForObject("http://STUDENT/student/find/all", RestResult.class);
//        return restResult;
//    }
//
//    public String test(){
//        return restTemplate.getForObject("http://STUDENT/test/hello", String.class);
//    }
//}
