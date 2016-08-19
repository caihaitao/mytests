package com.cc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Administrator on 2016/8/19.
 */
@Controller
@EnableWebMvc
public class IndexController {

    @RequestMapping("/xxx")
    public ModelAndView index() {
        System.err.print("index.........");
        return new ModelAndView("index.html");
    }
}
