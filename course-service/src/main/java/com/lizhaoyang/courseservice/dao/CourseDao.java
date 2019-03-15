package com.lizhaoyang.courseservice.dao;


import com.lizhaoyang.courseservice.domain.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-02-27 14:49
 */

@Mapper
public interface CourseDao {
    @Select("select * from tb_course")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "credit", property = "credit"),
            @Result(column = "type", property = "type"),
            @Result(column = "teacher", property = "teacher"),
            @Result(column = "section", property = "section"),
            @Result(column = "interval", property = "interval"),
            @Result(column = "room", property = "room"),
            @Result(column = "total", property = "total"),
            @Result(column = "rest", property = "rest")
    })
    List<Course> findAll();

    @Select("select * from tb_course where id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "credit", property = "credit"),
            @Result(column = "type", property = "type"),
            @Result(column = "teacher", property = "teacher"),
            @Result(column = "section", property = "section"),
            @Result(column = "interval", property = "interval"),
            @Result(column = "room", property = "room"),
            @Result(column = "total", property = "total"),
            @Result(column = "rest", property = "rest")
    })
    Course findById(@Param("id") int id);

    @Select("select * from tb_course where type = #{type}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "credit", property = "credit"),
            @Result(column = "type", property = "type"),
            @Result(column = "teacher", property = "teacher"),
            @Result(column = "section", property = "section"),
            @Result(column = "interval", property = "interval"),
            @Result(column = "room", property = "room"),
            @Result(column = "total", property = "total"),
            @Result(column = "rest", property = "rest")
    })
    List<Course> findByType(@Param("type") int type);

    @Select("select * from tb_course where teacher = #{teacher}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "credit", property = "credit"),
            @Result(column = "type", property = "type"),
            @Result(column = "teacher", property = "teacher"),
            @Result(column = "section", property = "section"),
            @Result(column = "interval", property = "interval"),
            @Result(column = "room", property = "room"),
            @Result(column = "total", property = "total"),
            @Result(column = "rest", property = "rest")
    })
    List<Course> findByTeacher(@Param("teacher") String teacher);

    @Select("select * from tb_course where rest > 0")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "credit", property = "credit"),
            @Result(column = "type", property = "type"),
            @Result(column = "teacher", property = "teacher"),
            @Result(column = "section", property = "section"),
            @Result(column = "interval", property = "interval"),
            @Result(column = "room", property = "room"),
            @Result(column = "total", property = "total"),
            @Result(column = "rest", property = "rest")
    })
    List<Course> findByRest();

    @Select("select rest from tb_course where id = #{id}")
    int findRestNum(@Param("id") int id);

    @Delete("delete from tb_course where id = #{id}")
    int deleteById(@Param("id") int id);

    @Insert("insert into tb_course(name,credit,type,teacher,section,`interval`,room,total,rest) values (#{name},#{credit},#{type},#{teacher},#{section},#{interval},#{room},#{total},#{rest})")
    int addCourse(Course course);

    @Insert({
            "<script>",
            "insert into tb_course(name,credit,type,teacher,section,`interval`,room,total,rest) values",
            "<foreach collection='courses' item='course' index='index' separator=','>",
            "(#{course.name},#{course.credit},#{course.type},#{course.teacher},#{course.section},#{course.interval},#{course.room},#{course.total},#{course.rest})",
            "</foreach>",
            "</script>"
    })
    int addAll(@Param(value = "courses") List<Course> courses);

    @Update("update tb_course set name=#{name},credit = #{credit},type=#{type},teacher=#{teacher},section=#{section},`interval`=#{interval},room=#{room},total=#{total},rest=#{rest} where id=#{id}")
    int updateCourse(Course course);

    @Update("update tb_course set rest = rest - '1' where id = #{id} and rest > 0")
    int decreRest(int id);

    @Update("update tb_course set rest = rest + '1' where id = #{id}")
    int increRest(int id);
}
