package com.cc.controller;

import com.cc.constants.SysCanstants;
import com.cc.exception.BizException;
import com.cc.model.Candidate;
import com.cc.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/8/18.
 */
@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public Object findAll() {
        return candidateService.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> add(Candidate candidate) {
        ResponseEntity<String> responseEntity;
        try {
            candidateService.addCandidate(candidate);
            responseEntity = new ResponseEntity<>(SysCanstants.SUCCESS, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(SysCanstants.ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/delete/{candidateId}", method = RequestMethod.POST)
    public ResponseEntity<String> delete(@PathVariable("candidateId") Integer candidateId) {
        ResponseEntity<String> responseEntity;
        try {
            candidateService.deleteCandidate(candidateId);
            responseEntity = new ResponseEntity<>(SysCanstants.SUCCESS, HttpStatus.OK);
        } catch (BizException e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(SysCanstants.ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
