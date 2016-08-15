package com.cc.handler;

import com.cc.model.Candidate;
import com.cc.model.VoteRecord;
import com.cc.service.CandidateService;
import com.cc.service.VoteRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2016/8/15.
 */
@Service
@Transactional
public class VoteHandler {
    @Autowired
    private VoteRecordService voteRecordService;
    @Autowired
    private CandidateService candidateService;

    public void vote(Candidate candidate,VoteRecord voteRecord) {
        //1.查找记录中mobile 当天是否已经投票

        //2.投票

        //3.添加记录信息
    }
}
