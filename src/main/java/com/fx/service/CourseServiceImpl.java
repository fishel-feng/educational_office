package com.fx.service;

import com.fx.dao.CourseMapper;
import com.fx.entity.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public PageBean findByTeacherByPage(Integer currentPage, Integer teacherId) {
        PageBean pageBean=new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalRows(courseMapper.getCountByTeacher(teacherId));
        int start=pageBean.getPageSize()*(pageBean.getCurrentPage()-1);
        int offset=pageBean.getPageSize();
        pageBean.setItems(courseMapper.findByTeacherByPage(start,offset,teacherId));
        return pageBean;
    }


}
