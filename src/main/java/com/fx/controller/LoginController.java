package com.fx.controller;

import com.fx.entity.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    /**
     * 起始登录页面
     *
     * @return login.jsp
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginUI() {
        return "../../login";
    }


    /**
     * 登录表单提交
     *
     * @param userInfo 用户信息
     * @return 重定向到，对应权限主页，没有则回到登录页
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(UserInfo userInfo) {
        //Shiro实现登录
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getPassword());
        Subject subject = SecurityUtils.getSubject();
        //根据不同用户权限返回对应页面
        subject.login(token);
        if (subject.hasRole("admin")) {
            return "redirect:admin/course_list/1";
        } else if (subject.hasRole("teacher")) {
            return "redirect:teacher/course_list/1";
        } else if (subject.hasRole("student")) {
            return "redirect:student/course_list/1";
        }
        return "redirect:login";
    }
}
