package com.cc.controller;

import com.cc.constants.SysCanstants;
import com.cc.exception.BizException;
import com.cc.model.Candidate;
import com.cc.model.PageData;
import com.cc.service.CandidateService;
import com.cc.service.StorageService;
import com.cc.util.ImageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/8/18.
 */
@Controller
@RequestMapping("/manage/candidate")
public class CandidateController {
    private static final Logger logger = LoggerFactory.getLogger(CandidateController.class);
    // 图片保存地址
    @Value("${image_savePath}")
    public String savePath;

    // 图片获取地址
    @Value("${image_relativePath}")
    public String relativePath;

    // 图片限制大小
    @Value("${image_size}")
    public Integer imageSize;

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private StorageService storageService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "manage/admin";
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public Object findAll(@RequestParam(required = true, defaultValue = "1") Integer page,
                          @RequestParam(required = false, defaultValue = "10") Integer rows, ModelMap modelMap) {
        logger.info("find all candidates");
        PageHelper.startPage(page, rows);
        List<Candidate> candidates = candidateService.findAll();

        PageInfo<Candidate> candidatePageInfo = new PageInfo<>(candidates);
        logger.info("find all candidates return {} items,total {} items", candidates.size(), candidatePageInfo.getTotal());

        PageData<Candidate> datas = new PageData<Candidate>(candidates);
        datas.setTotal(candidatePageInfo.getTotal());
        return datas;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> add(@RequestParam(value = "file", required = false) MultipartFile file, Candidate candidate,
                                      HttpServletRequest request) {
        ResponseEntity<String> responseEntity;
        try {
            String username = request.getRemoteUser();
            candidate.setVotes(0);
            candidate.setCreateDate(new Date());
            candidate.setLastUpdate(new Date());
            candidate.setLastUpdator(username);
            candidate.setVersion(0);
            if (!file.isEmpty()) {
                ImageUtil.checkFile(file, imageSize);
                String fileName = storageService.store(file);
                Path path = storageService.load(fileName);
                String imagePath = MvcUriComponentsBuilder.fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString())
                        .build().toString();
                candidate.setImagePath(imagePath);
            }

            candidateService.addCandidate(candidate);
            responseEntity = new ResponseEntity<>(SysCanstants.SUCCESS, HttpStatus.OK);
        } catch (BizException be) {
            responseEntity = new ResponseEntity<>(be.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            logger.error("add error:",e);
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

    @PostMapping(path = "/delete")
    public ResponseEntity<String> groupDelete(@RequestParam("ids") List<Integer> candidateIds) {
        logger.info("delete candidates :{}", candidateIds);
        ResponseEntity<String> responseEntity;
        try {
            candidateService.groupDelete(candidateIds);
            responseEntity = new ResponseEntity<>(SysCanstants.SUCCESS, HttpStatus.OK);
        } catch (BizException e) {
            logger.error(e.getMessage());
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            logger.error(e.getMessage());
            responseEntity = new ResponseEntity<>(SysCanstants.ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
