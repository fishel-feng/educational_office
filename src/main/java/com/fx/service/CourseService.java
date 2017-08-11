package com.fx.service;

import com.fx.entity.PageBean;

public interface CourseService {

    PageBean findByPage(Integer currentPage);

    PageBean findByTeacherByPage(Integer currentPage, Integer teacherId);
}
