package com.cc.controller;

import com.cc.constants.VoteErrorEnum;
import com.cc.exception.BizException;
import com.cc.handler.VoteHandler;
import com.cc.model.Candidate;
import com.cc.model.VoteRecordQuery;
import com.cc.util.MobileCheckUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/8/17.
 */
@Controller
@RequestMapping("/vote")
public class VoteController {

    private static final Logger logger = LoggerFactory.getLogger(VoteController.class);

    @Autowired
    private VoteHandler voteHandler;


    @RequestMapping(value = "/candidateId/{candidateId}/mobile/{mobile}")
    public ResponseEntity<String> vote(HttpServletRequest httpServletRequest, @PathVariable("candidateId") Integer candidateId, @PathVariable("mobile") String mobile) {
        ResponseEntity<String> responseEntity;
        try {
            Candidate candidate = new Candidate();
            candidate.setId(candidateId);

            VoteRecordQuery voteRecordQuery = new VoteRecordQuery();
            voteRecordQuery.setMobile(mobile);
            voteRecordQuery.setIp(httpServletRequest.getRemoteAddr());
            voteHandler.vote(candidate, voteRecordQuery);
            responseEntity = new ResponseEntity<>("success", HttpStatus.OK);
        } catch (BizException e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e1) {
            responseEntity = new ResponseEntity<>(VoteErrorEnum.SYSTEM_ERROR.getMsg(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping(path = "/doVote")
    public ResponseEntity<String> doVote(HttpServletRequest httpServletRequest, @RequestParam("voterId") Integer candidateId,
                                         @RequestParam("mobile") String mobile, @RequestParam("name") String name) {
        ResponseEntity<String> responseEntity;
        try {
            validateParams(candidateId,mobile,name);

            Candidate candidate = new Candidate();
            candidate.setId(candidateId);

            VoteRecordQuery voteRecordQuery = new VoteRecordQuery();
            voteRecordQuery.setMobile(mobile);
            voteRecordQuery.setIp(httpServletRequest.getRemoteAddr());
            voteHandler.vote(candidate, voteRecordQuery);
            responseEntity = new ResponseEntity<>("success", HttpStatus.OK);
        } catch (BizException e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e1) {
            logger.error("doVote error:",e1);
            responseEntity = new ResponseEntity<>(VoteErrorEnum.SYSTEM_ERROR.getMsg(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    private void validateParams(Integer candidateId, String mobile, String name) {
        if(candidateId == null || mobile == null || name == null) {
            throw new BizException("参数错误");
        }

        if(!MobileCheckUtil.isMobileNO(mobile)) {
            throw new BizException("电话号码错误");
        }
    }


}
