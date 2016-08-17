package com.cc.service;

import com.cc.BaseTest;
import com.cc.CandidateService;
import com.cc.model.Candidate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/8/15.
 */
public class CandidateTest extends BaseTest {
    @Autowired
    private CandidateService candidateService;

    @Test
    public void testAdd() {
        Candidate candidate = new Candidate();
        candidate.setVotes(0);
        candidate.setName("wu");
        candidate.setVersion(0);
        candidateService.addCandidate(candidate);
    }
}
