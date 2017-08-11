package com.fx.controller;

import com.fx.entity.PageBean;
import com.fx.service.CourseService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("course_list/{currentPage}")
    public String showCourse(Model model, @PathVariable Integer currentPage) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        Integer teacherId = Integer.parseInt(username);
        PageBean pageBean = courseService.findByTeacherByPage(currentPage, teacherId);
        model.addAttribute("pageBean", pageBean);
        return "teacher/courseList";
    }
}
