package com.fx.service;

import com.fx.entity.PageBean;

public interface StudentService {
    PageBean findSelectedCourseByPage(String username, Integer currentPage);

    PageBean findFinishedCourseByPage(String username, Integer currentPage);
}
