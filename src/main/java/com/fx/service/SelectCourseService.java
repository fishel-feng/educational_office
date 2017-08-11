package com.fx.service;

public interface SelectCourseService {
    int selectNewCourse(Integer studentId,Integer courseId);

    int dropCourse(Integer studentId, Integer courseId);
}
