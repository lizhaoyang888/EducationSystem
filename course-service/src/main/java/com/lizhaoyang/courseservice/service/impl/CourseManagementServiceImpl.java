package com.lizhaoyang.courseservice.service.impl;

import com.lizhaoyang.courseservice.dao.CourseDao;
import com.lizhaoyang.courseservice.dao.CourseManagementDao;
import com.lizhaoyang.courseservice.domain.CourseManagement;
import com.lizhaoyang.courseservice.exception.AddCourseManagementFaildException;
import com.lizhaoyang.courseservice.exception.DelCourseManagementFaildException;
import com.lizhaoyang.courseservice.service.CourseManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-02-27 16:48
 */

@Service
public class CourseManagementServiceImpl implements CourseManagementService {

    @Autowired
    private CourseManagementDao courseManagementDao;

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<CourseManagement> findAll() {
        return courseManagementDao.findAll();
    }

    @Override
    public CourseManagement findById(int id) {
        return courseManagementDao.findById(id);
    }

    @Override
    public List<CourseManagement> findByStudentId(int stuentId) {
        return courseManagementDao.findByStudentId(stuentId);
    }

    @Override
    public List<CourseManagement> findByCourseId(int courseId) {
        return courseManagementDao.findByCourseId(courseId);
    }

    @Override
    public int deleteById(int id) {
        return courseManagementDao.deleteById(id);
    }

    /**
     * 退课
     * @param courseManagement
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = DelCourseManagementFaildException.class)
    public int delCourseManagement(CourseManagement courseManagement) throws DelCourseManagementFaildException {
        int code1 = courseManagementDao.delCourseManagement(courseManagement);
        if (code1 > 0){
            int courseId = courseManagement.getCourseId();
            int code2 = courseDao.increRest(courseId);
            if (code2 > 0){
                return code2;
            }else {
                throw new DelCourseManagementFaildException("修改课程表剩余人数失败");
            }
        }else {
            throw new DelCourseManagementFaildException("删除选课表失败");
        }
    }

    /**
     * 选课
     * @param courseManagement
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = AddCourseManagementFaildException.class)
    public int addCourseManagement(CourseManagement courseManagement) throws AddCourseManagementFaildException{
        int courseId = courseManagement.getCourseId();
        int code1 = courseDao.decreRest(courseId);
        if (code1 > 0){
            int code2 = courseManagementDao.addCourseManagement(courseManagement);
            if (code2 > 0){
                return code2;
            }else {
                throw new AddCourseManagementFaildException("插入选课表失败");
            }
        }else {
            throw new AddCourseManagementFaildException("此课程已满员");
        }
    }
}
