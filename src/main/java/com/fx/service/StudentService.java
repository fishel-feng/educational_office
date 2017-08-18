package com.fx.service;

import com.fx.entity.PageBean;
import com.fx.entity.Student;

public interface StudentService {
    PageBean findSelectedCourseByPage(String username, Integer currentPage);

    PageBean findFinishedCourseByPage(String username, Integer currentPage);

    Student findById(Integer studentId);

    PageBean findStudentWithCourse(Integer currentPage);
}
