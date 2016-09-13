package com.cc.service;

import com.cc.BaseTest;
import com.cc.handler.VoteHandler;
import com.cc.model.Candidate;
import com.cc.model.Voter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/8/16.
 */
public class VoteHandlerTest extends BaseTest {
    @Autowired
    private VoteHandler voteHandler;

    @Test
    public void testVote() {
        Candidate candidate = new Candidate();
        candidate.setId(1);

        Voter voter = new Voter("cc", "192.168.1.1", "18613139163");
        voteHandler.vote(candidate, voter);
    }


}
