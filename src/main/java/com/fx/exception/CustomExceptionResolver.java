package com.fx.exception;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomExceptionResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        String message = null;
        if (e instanceof CustomException) {
            message = e.getMessage();
        } else if (e instanceof UnknownAccountException) {
            //用户名错误异常
            message = "没有该用户";
        } else if (e instanceof IncorrectCredentialsException) {
            //用户名错误异常
            message = "密码错误";
        } else {
            message = "未知错误";
        }
        //错误信息传递和错误页面跳转
        modelAndView.addObject("message", message);
        modelAndView.setViewName("error");
        return modelAndView;
    }

}
