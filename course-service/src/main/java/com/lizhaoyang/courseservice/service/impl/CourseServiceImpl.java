package com.lizhaoyang.courseservice.service.impl;

import com.lizhaoyang.courseservice.dao.CourseDao;
import com.lizhaoyang.courseservice.domain.Course;
import com.lizhaoyang.courseservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-02-27 16:43
 */

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Override
    public Course findById(int id) {
        return courseDao.findById(id);
    }

    @Override
    public List<Course> findByType(int type) {
        return courseDao.findByType(type);
    }

    @Override
    public List<Course> findByTeacher(String teacher) {
        return courseDao.findByTeacher(teacher);
    }

    @Override
    public List<Course> findByRest() {
        return courseDao.findByRest();
    }

    @Override
    public int findRestNum(int id) {
        return courseDao.findRestNum(id);
    }

    @Override
    public int deleteById(int id) {
        return courseDao.deleteById(id);
    }

    @Override
    public int addCourse(Course course) {
        return courseDao.addCourse(course);
    }

    @Override
    public int addAll(List<Course> courses) {
        return courseDao.addAll(courses);
    }

    @Override
    public int updateCourse(Course course) {
        return courseDao.updateCourse(course);
    }

    @Override
    public int increRest(int id) {
        return courseDao.increRest(id);
    }

    @Override
    public int decreRest(int id) {
        return courseDao.decreRest(id);
    }
}
