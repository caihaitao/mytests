package com.cc.controller;

import com.cc.model.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/8/24.
 */
@Controller
public class LoginController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Value("${user.super.username}")
    private String superUsername;
    @Value("${user.super.password}")
    private String superPassword;
    @Value("${user.super.role}")
    private String role;

    @RequestMapping("/login")
    public String login(ModelMap modelMap) {
        User user = new User();
        modelMap.addAttribute(user);
        return "login";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(User user) {
        logger.info("login user:" + user);
        return "redirect:index";
    }
}
