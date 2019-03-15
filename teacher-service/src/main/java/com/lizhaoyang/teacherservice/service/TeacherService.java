package com.lizhaoyang.teacherservice.service;



import com.lizhaoyang.teacherservice.domain.Teacher;

import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-02-27 16:21
 */
public interface TeacherService {
    List<Teacher> findAll();
    Teacher login(int id, String password);
    Teacher findById(int id);
    int deleteById(int id);
    int addTeacher(Teacher teacher);
    int addAll(List<Teacher> teachers);
    int updateTeacher(Teacher teacher);
}
