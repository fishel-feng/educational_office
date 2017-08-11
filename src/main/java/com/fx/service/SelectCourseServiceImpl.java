package com.fx.service;

import com.fx.dao.SelectCourseMapper;
import com.fx.entity.PageBean;
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

    @Override
    public int dropCourse(Integer studentId, Integer courseId) {
        return selectCourseMapper.delete(studentId,courseId);
    }

    @Override
    public PageBean findByCourseIdWithStudent(Integer currentPage, Integer courseId) {
        PageBean pageBean=new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalRows(selectCourseMapper.getCountByCourseId(courseId));
        int start=pageBean.getPageSize()*(pageBean.getCurrentPage()-1);
        int offset=pageBean.getPageSize();
        pageBean.setItems(selectCourseMapper.findByCourseIdWithStudent(start,offset,courseId));
        return pageBean;
    }
}
