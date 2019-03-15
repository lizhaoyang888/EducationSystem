package com.lizhaoyang.studentservice.dao;


import com.lizhaoyang.studentservice.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: lichaoyang
 * @Date: 2019-02-27 14:50
 */

@Mapper
public interface StudentDao {

    @Select("select * from tb_student")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "password", property = "password"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "grade", property = "grade"),
            @Result(column = "clazz", property = "clazz")
    })
    List<Student> findAll();

    @Select("select * from tb_student where id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "password", property = "password"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "grade", property = "grade"),
            @Result(column = "clazz", property = "clazz")
    })
    Student findById(@Param("id") int id);

    @Select("select * from tb_student where id = #{id} and password = #{password}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "password", property = "password"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "grade", property = "grade"),
            @Result(column = "clazz", property = "clazz")
    })
    Student login(@Param("id") int id, @Param("password") String password);

    @Delete("delete from tb_student where id = #{id}")
    int deleteById(@Param("id") int id);

    @Insert("insert into tb_student(name,password,sex,grade,clazz) values (#{name},#{password},#{sex},#{grade},#{clazz})")
    int addStudent(Student student);

    @Insert({
            "<script>",
            "insert into tb_student(name,password,sex,grade,clazz) values",
            "<foreach collection='students' item='student' index='index' separator=','>",
            "(#{student.name},#{student.password},#{student.sex},#{student.grade},#{student.clazz})",
            "</foreach>",
            "</script>"
    })
    int addAll(@Param(value = "students") List<Student> students);

    @Update("update tb_student set name=#{name},password = #{password},sex=#{sex},grade=#{grade},clazz=#{clazz} where id=#{id}")
    int updateStudent(Student student);
}
