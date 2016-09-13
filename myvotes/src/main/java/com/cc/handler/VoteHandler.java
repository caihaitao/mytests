package com.cc.handler;

import com.cc.constants.VoteErrorEnum;
import com.cc.exception.BizException;
import com.cc.model.Candidate;
import com.cc.model.VoteRecord;
import com.cc.model.Voter;
import com.cc.service.CandidateService;
import com.cc.service.VoteRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

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

    public void vote(Candidate candidate, Voter voter) {
        //1.查找记录中mobile 当天是否已经投票
//        LocalDate today = LocalDate.now();
        Date today = new Date();
        VoteRecord record = voteRecordService.selectByMobileAndDate(voter.getMobile(), today);

        if (record != null) {
            throw new BizException(VoteErrorEnum.ALREADY_VOTE.getMsg());
        }

        //2.查找记录中ip 当天是否已经投票
        VoteRecord record2 = voteRecordService.selectByIpAndDate(voter.getIp(), today);

        if (record2 != null) {
            throw new BizException(VoteErrorEnum.USE_SAME_IP_VOTE.getMsg());
        }

        //3.投票
        candidateService.vote(candidate);

        //4.添加记录信息
        VoteRecord voteRecord = new VoteRecord().setIp(voter.getIp()).setMobile(voter.getMobile()).setLastVoteDate(today).setName(voter.getName());
        voteRecordService.addRecord(voteRecord);
    }

}
