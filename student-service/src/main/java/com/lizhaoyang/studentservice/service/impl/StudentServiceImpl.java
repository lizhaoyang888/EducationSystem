package com.lizhaoyang.studentservice.service.impl;

import com.lizhaoyang.studentservice.dao.StudentDao;
import com.lizhaoyang.studentservice.domain.Student;
import com.lizhaoyang.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-02-27 16:37
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentDao.findById(id);
    }

    @Override
    public Student login(int id, String password) {
        return studentDao.login(id,password);
    }

    @Override
    public int deleteById(int id) {
        return studentDao.deleteById(id);
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public int addAll(List<Student> students) {
        return studentDao.addAll(students);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }
}
