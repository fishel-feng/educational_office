package com.fx.controller;

import com.fx.entity.Course;
import com.fx.entity.PageBean;
import com.fx.service.CourseService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("course_list/{currentPage}")
    public String showCourse(Model model, @PathVariable Integer currentPage){
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        Integer teacherId=Integer.parseInt(username);
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalRows(courseService.getCountByTeacher(teacherId));
        List<Course> courseList = courseService.findByTeacherByPage(pageBean,teacherId);
        pageBean.setItems(courseList);
        model.addAttribute("pageBean", pageBean);
        return "teacher/courseList";
    }
}
