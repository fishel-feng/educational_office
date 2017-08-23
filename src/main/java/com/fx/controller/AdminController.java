package com.fx.controller;

import com.fx.entity.College;
import com.fx.entity.Course;
import com.fx.entity.PageBean;
import com.fx.entity.Teacher;
import com.fx.exception.CustomException;
import com.fx.service.CollegeService;
import com.fx.service.CourseService;
import com.fx.service.StudentService;
import com.fx.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CollegeService collegeService;

    @RequestMapping("course_list/{currentPage}")
    public String showCourse(Model model, @PathVariable Integer currentPage) {
        PageBean pageBean = courseService.findByPage(currentPage);
        model.addAttribute("pageBean", pageBean);
        return "admin/courseList";
    }

    @RequestMapping("course_edit/{courseId}")
    public String changeCourseUI(Model model, @PathVariable Integer courseId) throws CustomException {
        if (courseId == null) {
            return "redirect:/admin/courseList";
        }
        Course course = courseService.findById(courseId);
        if (course == null) {
            throw new CustomException("未找到该课程");
        }
        List<Teacher> teacherList = teacherService.findAll();
        List<College> collegeList = collegeService.findAll();
        model.addAttribute("course", course);
        model.addAttribute("teacherList", teacherList);
        model.addAttribute("collegeList", collegeList);
        return "admin/courseEdit";
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
