package com.cc.controller;

import com.cc.model.User;
import com.cc.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(ModelMap modelMap) {
        User user = new User();
        modelMap.addAttribute(user);
        return "login";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(User user, ModelMap modelMap) {
        logger.info("login user:" + user);
        User u = userService.findUser(user.getUsername(), user.getPassword());
        if (u != null) {
            modelMap.addAttribute("sessionUser", u);
            return "redirect:index";
        }
        return "login";
    }
}
