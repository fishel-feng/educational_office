package com.fx.service;

import com.fx.entity.Course;
import com.fx.entity.PageBean;

import java.util.List;

public interface CourseService {

    PageBean findByPage(Integer currentPage);

    int getCountByTeacher(Integer teacherId);

    List<Course> findByTeacherByPage(PageBean pageBean,Integer teacherId);
}
