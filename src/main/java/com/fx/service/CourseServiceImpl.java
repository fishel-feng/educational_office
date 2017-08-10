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
    public PageBean findByPage(Integer currentPage) {
        PageBean pageBean=new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalRows(courseMapper.getCourseCount());
        int start=pageBean.getPageSize()*(pageBean.getCurrentPage()-1);
        int offset=pageBean.getPageSize();
        pageBean.setItems(courseMapper.findByPage(start,offset));
        return pageBean;
    }

    @Override
    public int getCountByTeacher(Integer teacherId) {
        return courseMapper.getCountByTeacher(teacherId);
    }

    @Override
    public List<Course> findByTeacherByPage(PageBean pageBean, Integer teacherId) {
        int start=pageBean.getPageSize()*(pageBean.getCurrentPage()-1);
        int offset=pageBean.getPageSize();
        return courseMapper.findByTeacherByPage(start,offset,teacherId);
    }

}
