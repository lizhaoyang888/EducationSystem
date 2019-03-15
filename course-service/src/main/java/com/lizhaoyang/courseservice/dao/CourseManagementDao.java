package com.lizhaoyang.courseservice.dao;


import com.lizhaoyang.courseservice.domain.CourseManagement;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-02-27 14:49
 */

@Mapper
public interface CourseManagementDao {
    @Select("select * from tb_course_management")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "student_id", property = "studentId"),
            @Result(column = "course_id", property = "courseId")
    })
    List<CourseManagement> findAll();

    @Select("select * from tb_course_management where id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "student_id", property = "studentId"),
            @Result(column = "course_id", property = "courseId")
    })
    CourseManagement findById(@Param("id") int id);

    @Select("select * from tb_course_management where student_id = #{stuentId}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "student_id", property = "studentId"),
            @Result(column = "course_id", property = "courseId")
    })
    List<CourseManagement> findByStudentId(@Param("stuentId") int stuentId);

    @Select("select * from tb_course_management where course_id = #{courseId}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "student_id", property = "studentId"),
            @Result(column = "course_id", property = "courseId")
    })
    List<CourseManagement> findByCourseId(@Param("courseId") int courseId);

    @Delete("delete from tb_course_management where id = #{id}")
    int deleteById(@Param("id") int id);

    @Delete("delete from tb_course_management where student_id = #{studentId} and course_id = #{courseId}")
    int delCourseManagement(CourseManagement courseManagement);

    @Insert("insert into tb_course_management(student_id,course_id) values (#{studentId},#{courseId})")
    int addCourseManagement(CourseManagement courseManagement);
}
