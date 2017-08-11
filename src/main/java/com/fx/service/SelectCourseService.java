package com.fx.service;

import com.fx.entity.PageBean;

public interface SelectCourseService {
    int selectNewCourse(Integer studentId,Integer courseId);

    int dropCourse(Integer studentId, Integer courseId);

    PageBean findByCourseIdWithStudent(Integer currentPage, Integer courseId);
}
