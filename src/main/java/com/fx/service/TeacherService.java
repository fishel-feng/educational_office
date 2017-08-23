package com.fx.service;

import com.fx.entity.PageBean;
import com.fx.entity.Teacher;

import java.util.List;

public interface TeacherService {
    PageBean findTeacherWithCourse(Integer currentPage);

    List<Teacher> findAll();
}
