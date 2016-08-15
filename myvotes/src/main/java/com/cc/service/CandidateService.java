package com.cc.service;

import com.cc.mapper.CandidateMapper;
import com.cc.model.Candidate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
@Service
public class CandidateService {
    private static final Logger logger = LoggerFactory.getLogger(CandidateService.class);
    @Autowired
    private CandidateMapper candidateMapper;

    public void addCandidate(Candidate candidate) {
        logger.info("add candidate:{}",candidate);
        Assert.notNull(candidate,"add -candidate should not be null");
        candidateMapper.insert(candidate);
    }

    public void updateCandidate(Candidate candidate) {
        logger.info("update candidate:{}",candidate);
        Assert.notNull(candidate,"update -candidate should not be null");
        candidateMapper.update(candidate);
    }

    public List<Candidate> findAll() {
        logger.info("find all candidates");
        List<Candidate> candidates = candidateMapper.findAll();
        logger.info("find all candidates return {} items",candidates.size());
        return candidates;
    }

}
