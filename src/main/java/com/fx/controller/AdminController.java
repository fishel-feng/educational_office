package com.fx.controller;

import com.fx.entity.*;
import com.fx.exception.CustomException;
import com.fx.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("course_list/{currentPage}")
    public String showCourse(Model model, @PathVariable Integer currentPage) {
        PageBean pageBean = courseService.findByPage(currentPage);
        model.addAttribute("pageBean", pageBean);
        return "admin/courseList";
    }

    @RequestMapping(value = "course_edit/{courseId}", method = RequestMethod.GET)
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

    @RequestMapping("/user_reset")
    public String resetUser(UserInfo userInfo) throws Exception {
        UserInfo user = userInfoService.findByName(userInfo.getUsername());
        if (user != null) {
            if (user.getRoleId() == 3) {
                throw new CustomException("该账户为管理员账户，没法修改");
            }
            user.setPassword(userInfo.getPassword());
            userInfoService.updateByName(userInfo.getUsername(), user);
        } else {
            throw new CustomException("没找到该用户");
        }
        return "admin/userReset";
    }

    @RequestMapping("/password_reset")
    public String resetPassword(UserInfo userInfo) {
        return "admin/passwordReset";
    }

}
