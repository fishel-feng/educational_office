package com.fx.dao;

import com.fx.entity.CourseWithMark;
import com.fx.entity.SelectCourse;
import com.fx.entity.SelectCourseWithStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectCourseMapper {
    int insert(SelectCourse record);

    int insertSelective(SelectCourse record);

    int getSelectedCourseCount(Integer studentId);

    List<CourseWithMark> findSelectedCourseByPage(@Param("studentId") Integer studentId, @Param("start") int start, @Param("offset") int offset);

    int getFinishedCourseCount(Integer studentId);

    List<CourseWithMark> findFinishedCourseByPage(@Param("studentId") Integer studentId, @Param("start") int start, @Param("offset") int offset);

    int insertIgnore(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId);

    int delete(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId);

    int getCountByCourseId(Integer courseId);

    List<SelectCourseWithStudent> findByCourseIdWithStudent(@Param("start") int start, @Param("offset") int offset, @Param("courseId") Integer courseId);
}