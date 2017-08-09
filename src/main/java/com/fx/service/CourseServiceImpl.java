package com.fx.service;

import com.fx.dao.CourseMapper;
import com.fx.entity.Course;
import com.fx.entity.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public int getCourseCount() {
        return courseMapper.getCourseCount();
    }

    @Override
    public List<Course> findByPage(PageBean pageBean) {
        int start=pageBean.getPageSize()*(pageBean.getCurrentPage()-1);
        int offset=pageBean.getPageSize();
        return courseMapper.findByPage(start,offset);
    }
}
