package com.fx.service;

import com.fx.entity.PageBean;

public interface TeacherService {
    PageBean findTeacherWithCourse(Integer currentPage);
}
