package com.cc.controller;

import com.cc.handler.VoteHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/8/17.
 */
@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private VoteHandler voteHandler;

    @RequestMapping(value = "/candidates", method = RequestMethod.GET)
    public Object findAllCandidates(HttpServletRequest request) {
        System.out.print(request.getRemoteAddr());
        return voteHandler.findAllCandidates();
    }
}
