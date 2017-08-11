package com.fx.controller;

import com.fx.entity.PageBean;
import com.fx.entity.Student;
import com.fx.service.CourseService;
import com.fx.service.SelectCourseService;
import com.fx.service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private SelectCourseService selectCourseService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("course_list/{currentPage}")
    public String showCourse(Model model, @PathVariable Integer currentPage) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        Integer teacherId = Integer.parseInt(username);
        PageBean pageBean = courseService.findByTeacherByPage(currentPage, teacherId);
        model.addAttribute("pageBean", pageBean);
        return "teacher/courseList";
    }

    @RequestMapping("student/{courseId}/{currentPage}")
    public String showStudentOfCourse(Model model, @PathVariable Integer courseId, @PathVariable Integer currentPage) {
        PageBean pageBean = selectCourseService.findByCourseIdWithStudent(currentPage, courseId);
        model.addAttribute("pageBean", pageBean);
        return "teacher/showStudent";
    }

    @RequestMapping("mark/{courseId}/{studentId}")
    public String markCourse(Model model, @PathVariable Integer courseId, @PathVariable Integer studentId) {
        Student student = studentService.findById(studentId);
        model.addAttribute("student", student);
        model.addAttribute("courseId", courseId);
        return "teacher/mark";
    }

    @ResponseBody
    @RequestMapping("mark")
    public String mark(HttpServletRequest request) {
        //TODO 异步打分请求
        return "";
    }

    @RequestMapping("reset_password")
    public String passwordRest() {
        return "teacher/resetPassword";
    }
}
