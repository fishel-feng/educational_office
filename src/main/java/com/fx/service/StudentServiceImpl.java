package com.fx.service;

import com.fx.dao.SelectCourseMapper;
import com.fx.dao.StudentMapper;
import com.fx.entity.CourseWithMark;
import com.fx.entity.PageBean;
import com.fx.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SelectCourseMapper selectCourseMapper;

    @Override
    public PageBean findSelectedCourseByPage(String username, Integer currentPage) {
        PageBean pageBean=new PageBean();
        pageBean.setCurrentPage(currentPage);
        Integer studentId=Integer.parseInt(username);
        pageBean.setTotalRows(selectCourseMapper.getSelectedCourseCount(studentId));
        int start=pageBean.getPageSize()*(pageBean.getCurrentPage()-1);
        int offset=pageBean.getPageSize();
        List<CourseWithMark> courseWithMarks=selectCourseMapper.findSelectedCourseByPage(studentId,start,offset);
        pageBean.setItems(courseWithMarks);
        return pageBean;
    }

    @Override
    public PageBean findFinishedCourseByPage(String username, Integer currentPage) {
        PageBean pageBean=new PageBean();
        pageBean.setCurrentPage(currentPage);
        Integer studentId=Integer.parseInt(username);
        pageBean.setTotalRows(selectCourseMapper.getFinishedCourseCount(studentId));
        int start=pageBean.getPageSize()*(pageBean.getCurrentPage()-1);
        int offset=pageBean.getPageSize();
        List<CourseWithMark> courseWithMarks=selectCourseMapper.findFinishedCourseByPage(studentId,start,offset);
        pageBean.setItems(courseWithMarks);
        return pageBean;
    }

    @Override
    public Student findById(Integer studentId){
        return studentMapper.selectByPrimaryKey(studentId);
    }
}
