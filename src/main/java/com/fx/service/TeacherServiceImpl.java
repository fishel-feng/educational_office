package com.fx.service;

import com.fx.dao.TeacherMapper;
import com.fx.entity.PageBean;
import com.fx.entity.Teacher;
import com.fx.entity.TeacherWithCollege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public PageBean findTeacherWithCourse(Integer currentPage) {
        PageBean pageBean=new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalRows(teacherMapper.getCount());
        int start=pageBean.getPageSize()*(pageBean.getCurrentPage()-1);
        int offset=pageBean.getPageSize();
        List<TeacherWithCollege> teacherWithColleges=teacherMapper.findAllByPage(start,offset);
        pageBean.setItems(teacherWithColleges);
        return pageBean;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherMapper.findAll();
    }
}
