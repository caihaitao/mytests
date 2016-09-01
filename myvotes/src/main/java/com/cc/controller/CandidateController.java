package com.cc.controller;

import com.cc.constants.SysCanstants;
import com.cc.exception.BizException;
import com.cc.model.Candidate;
import com.cc.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/8/18.
 */
@Controller
@RequestMapping("/manage/candidate")
public class CandidateController {

    // 图片保存地址
    @Value("${image_savePath}")
    public String savePath;

    // 图片获取地址
    @Value("${image_relativePath}")
    public String relativePath;

    @Autowired
    private CandidateService candidateService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "manage/admin";
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public Object findAll() {
        return candidateService.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> add(@RequestParam(value = "file", required = false) MultipartFile file, Candidate candidate,
                                      HttpServletRequest request) {
        ResponseEntity<String> responseEntity;
        try {
            String username = request.getRemoteUser();
            candidateService.addCandidate(candidate, username);
            responseEntity = new ResponseEntity<>(SysCanstants.SUCCESS, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(SysCanstants.ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/delete/{candidateId}", method = RequestMethod.GET)
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
