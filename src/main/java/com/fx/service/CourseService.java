package com.fx.service;

import com.fx.entity.Course;
import com.fx.entity.PageBean;

import java.util.List;

public interface CourseService {

    int getCourseCount();

    List<Course> findByPage(PageBean pageBean);
}
