package com.lizhaoyang.courseservice.service;



import com.lizhaoyang.courseservice.domain.CourseManagement;
import com.lizhaoyang.courseservice.exception.AddCourseManagementFaildException;
import com.lizhaoyang.courseservice.exception.DelCourseManagementFaildException;

import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-02-27 16:22
 */
public interface CourseManagementService {
    List<CourseManagement> findAll();
    CourseManagement findById(int id);
    List<CourseManagement> findByStudentId(int stuentId);
    List<CourseManagement> findByCourseId(int courseId);
    int deleteById(int id);
    int addCourseManagement(CourseManagement courseManagement) throws AddCourseManagementFaildException;
    int delCourseManagement(CourseManagement courseManagement) throws DelCourseManagementFaildException;
}
