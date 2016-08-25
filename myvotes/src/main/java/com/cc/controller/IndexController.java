package com.cc.controller;

import com.cc.model.Candidate;
import com.cc.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2016/8/19.
 */
@Controller
public class IndexController {

    @Autowired
    private CandidateService candidateService;

    @RequestMapping(value = {"/", "/index"})
    @PreAuthorize("hasRole('admin')")
    public String index(ModelMap modelMap) {
        List<Candidate> candidates = candidateService.findAll();
        modelMap.addAttribute("candidates", candidates);

        return "index";
    }
}
