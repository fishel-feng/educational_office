package com.fx.controller;

import com.fx.entity.Course;
import com.fx.entity.PageBean;
import com.fx.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("course_list/{currentPage}")
    public String showCourse(Model model, @PathVariable Integer currentPage) {
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalRows(courseService.getCourseCount());
        List<Course> courseList = courseService.findByPage(pageBean);
        pageBean.setItems(courseList);
        model.addAttribute("pageBean", pageBean);
        return "student/courseList";
    }


}
