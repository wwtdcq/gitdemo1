package com.znlh.controller;

import com.znlh.bean.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setUsername("ww");
        user.setPassword("1111");
        modelAndView.addObject("user",user);
        modelAndView.setViewName("/user.jsp");
        return modelAndView;
    }
}
