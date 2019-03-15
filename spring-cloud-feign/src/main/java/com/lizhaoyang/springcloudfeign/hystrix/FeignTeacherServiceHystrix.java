package com.lizhaoyang.springcloudfeign.hystrix;

import com.lizhaoyang.springcloudfeign.domain.Teacher;
import com.lizhaoyang.springcloudfeign.service.FeignTeacherService;
import com.lizhaoyang.springcloudfeign.util.RestResult;
import com.lizhaoyang.springcloudfeign.util.RestResultGenerator;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-03-04 14:32
 */

@Component
public class FeignTeacherServiceHystrix implements FeignTeacherService {

    @Override
    public String test() {
        return "sorry,此服务因出错已熔断";
    }

    @Override
    public RestResult<List<Teacher>> findAll() {
        return RestResultGenerator.createFailResult(500,"sorry,此服务因出错已熔断");
    }
}
