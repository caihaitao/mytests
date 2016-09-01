package com.cc.controller;

import com.cc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/8/24.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(ModelMap modelMap) {
        User user = new User();
        modelMap.addAttribute(user);
        return "login";
    }

}
