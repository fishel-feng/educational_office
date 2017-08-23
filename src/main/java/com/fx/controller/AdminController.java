package com.fx.controller;

import com.fx.entity.PageBean;
import com.fx.service.CourseService;
import com.fx.service.StudentService;
import com.fx.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("course_list/{currentPage}")
    public String showCourse(Model model, @PathVariable Integer currentPage) {
        PageBean pageBean = courseService.findByPage(currentPage);
        model.addAttribute("pageBean", pageBean);
        return "admin/courseList";
    }

    @RequestMapping("/student_list/{currentPage}")
    public String showStudent(Model model, @PathVariable Integer currentPage) {
        PageBean pageBean = studentService.findStudentWithCourse(currentPage);
        model.addAttribute("pageBean", pageBean);
        return "admin/studentList";
    }

    @RequestMapping("/teacher_list/{currentPage}")
    public String showTeacher(Model model, @PathVariable Integer currentPage) {
        PageBean pageBean = teacherService.findTeacherWithCourse(currentPage);
        model.addAttribute("pageBean", pageBean);
        return "admin/teacherList";
    }

}
