package com.lizhaoyang.courseservice.service;


import com.lizhaoyang.courseservice.domain.Course;

import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-02-27 16:21
 */
public interface CourseService {
    List<Course> findAll();
    Course findById(int id);
    List<Course> findByType(int type);
    List<Course> findByTeacher(String teacher);
    List<Course> findByRest();
    int findRestNum(int id);
    int deleteById(int id);
    int addCourse(Course course);
    int addAll(List<Course> courses);
    int updateCourse(Course course);
    int increRest(int id);
    int decreRest(int id);
}
