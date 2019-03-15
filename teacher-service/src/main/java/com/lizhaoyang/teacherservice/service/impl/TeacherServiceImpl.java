package com.lizhaoyang.teacherservice.service.impl;

import com.lizhaoyang.teacherservice.dao.TeacherDao;
import com.lizhaoyang.teacherservice.domain.Teacher;
import com.lizhaoyang.teacherservice.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-02-27 16:39
 */

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }

    @Override
    public Teacher findById(int id) {
        return teacherDao.findById(id);
    }

    @Override
    public Teacher login(int id, String password) {
        return teacherDao.login(id,password);
    }

    @Override
    public int deleteById(int id) {
        return teacherDao.deleteById(id);
    }

    @Override
    public int addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher);
    }

    @Override
    public int addAll(List<Teacher> teachers) {
        return teacherDao.addAll(teachers);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherDao.updateTeacher(teacher);
    }
}
