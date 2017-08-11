package com.fx.service;

import com.fx.dao.SelectCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectCourseServiceImpl implements SelectCourseService {

    @Autowired
    private SelectCourseMapper selectCourseMapper;

    @Override
    public int selectNewCourse(Integer studentId,Integer courseId) {
        return selectCourseMapper.insertIgnore(studentId,courseId);
    }
}
