package com.lizhaoyang.teacherservice.dao;


import com.lizhaoyang.teacherservice.domain.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-02-27 14:50
 */

@Mapper
public interface TeacherDao {
    @Select("select * from tb_teacher")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "password", property = "password"),
            @Result(column = "sex", property = "sex")
    })
    List<Teacher> findAll();

    @Select("select * from tb_teacher where id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "password", property = "password"),
            @Result(column = "sex", property = "sex")
    })
    Teacher findById(@Param("id") int id);

    @Select("select * from tb_teacher where id = #{id} and password = #{password}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "password", property = "password"),
            @Result(column = "sex", property = "sex")
    })
    Teacher login(@Param("id") int id, @Param("password") String password);

    @Delete("delete from tb_teacher where id = #{id}")
    int deleteById(@Param("id") int id);

    @Insert("insert into tb_teacher(name,password,sex) values (#{name},#{password},#{sex})")
    int addTeacher(Teacher teacher);

    @Insert({
            "<script>",
            "insert into tb_teacher(name,password,sex) values",
            "<foreach collection='teachers' item='teacher' index='index' separator=','>",
            "(#{teacher.name},#{teacher.password},#{teacher.sex})",
            "</foreach>",
            "</script>"
    })
    int addAll(@Param(value = "teachers") List<Teacher> teachers);

    @Update("update tb_teacher set name=#{name},password = #{password},sex=#{sex} where id=#{id}")
    int updateTeacher(Teacher teacher);
}
