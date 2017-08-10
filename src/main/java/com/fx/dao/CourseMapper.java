package com.fx.dao;

import com.fx.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    int getCourseCount();

    List<Course> findByPage(@Param("start") int start, @Param("offset") int offset);

    int getCountByTeacher(Integer teacherId);

    List<Course> findByTeacherByPage(@Param("start") int start, @Param("offset") int offset, @Param("teacherId") Integer teacherId);
}