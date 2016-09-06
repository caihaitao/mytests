package com.cc.service;

import com.cc.BaseTest;
import com.cc.model.Candidate;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        String username = "cc";
        candidate.setLastUpdator(username);
        candidateService.addCandidate(candidate);
    }

    @Test
    public void testList() {
        PageHelper.startPage(1, 10);
        List<Candidate> candidateList = candidateService.findAll();
        candidateList.forEach(candidate -> System.out.println(candidate.getName()));
        PageInfo<Candidate> pageInfo = new PageInfo<>(candidateList);
        long total = pageInfo.getTotal();
        System.err.println(total);
    }
}
