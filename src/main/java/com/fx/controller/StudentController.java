package com.fx.controller;

import com.fx.entity.PageBean;
import com.fx.service.CourseService;
import com.fx.service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("course_list/{currentPage}")
    public String showCourse(Model model, @PathVariable Integer currentPage) {
        PageBean pageBean = courseService.findByPage(currentPage);
        model.addAttribute("pageBean", pageBean);
        return "student/courseList";
    }

    @RequestMapping("course_selected/{currentPage}")
    public String selectedCourse(Model model, @PathVariable Integer currentPage){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        PageBean pageBean=studentService.findSelectedCourseByPage(username,currentPage);
        model.addAttribute("pageBean",pageBean);
        return "student/selectedCourse";
    }

    @RequestMapping("course_finished/{currentPage}")
    public String finishedCourse(Model model, @PathVariable Integer currentPage){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        PageBean pageBean=studentService.findFinishedCourseByPage(username,currentPage);
        model.addAttribute("pageBean",pageBean);
        return "student/finishedCourse";
    }

    @RequestMapping("reset_password")
    public String passwordRest() throws Exception {
        return "student/resetPassword";
    }

}
