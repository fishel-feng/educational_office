package com.fx.dao;

import com.fx.entity.SelectCourse;

public interface SelectCourseMapper {
    int insert(SelectCourse record);

    int insertSelective(SelectCourse record);
}