package com.fx.dao;

import com.fx.entity.Student;
import com.fx.entity.StudentWithCollege;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer studentId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    int getCount();

    List<StudentWithCollege> findAllByPage(@Param("start") int start, @Param("offset") int offset);
}