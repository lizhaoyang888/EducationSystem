package com.lizhaoyang.springcloudfeign.hystrix;

import com.lizhaoyang.springcloudfeign.domain.Student;
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
public class FeignStudentServiceHystrix implements FeignStudentService {

    @Override
    public String test() {
        return "sorry,此服务因出错已熔断";
    }

    @Override
    public RestResult<List<Student>> findAll() {
        return RestResultGenerator.createFailResult(500,"sorry,此服务因出错已熔断");
    }
}
