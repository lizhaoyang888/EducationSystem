package com.lizhaoyang.studentservice.service;



import com.lizhaoyang.studentservice.domain.Student;

import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-02-27 16:20
 */
public interface StudentService {
    List<Student> findAll();
    Student login(int id, String password);
    Student findById(int id);
    int deleteById(int id);
    int addStudent(Student student);
    int addAll(List<Student> students);
    int updateStudent(Student student);
}
