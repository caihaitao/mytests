package com.cc.handler;

import com.cc.constants.VoteErrorEnum;
import com.cc.exception.BizException;
import com.cc.model.Candidate;
import com.cc.model.VoteRecord;
import com.cc.model.VoteRecordQuery;
import com.cc.service.CandidateService;
import com.cc.service.VoteRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

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

    public void vote(Candidate candidate, VoteRecordQuery voteRecordQuery) {
        //1.查找记录中mobile 当天是否已经投票
//        LocalDate today = LocalDate.now();
        Date today = new Date();
        VoteRecord record = voteRecordService.selectByMobileAndDate(voteRecordQuery.getMobile(), today);

        if (record != null) {
            throw new BizException(VoteErrorEnum.ALREADY_VOTE.getMsg());
        }

        //2.投票
        candidateService.vote(candidate);

        //3.添加记录信息
        VoteRecord voteRecord = new VoteRecord().setIp(voteRecordQuery.getIp()).setMobile(voteRecordQuery.getMobile()).setLastVoteDate(today);
        voteRecordService.addRecord(voteRecord);
    }

}
