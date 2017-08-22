package com.fx.dao;

import com.fx.entity.Teacher;
import com.fx.entity.TeacherWithCollege;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer teacherId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teacherId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    int getCount();

    List<TeacherWithCollege> findAllByPage(@Param("start") int start, @Param("offset") int offset);
}