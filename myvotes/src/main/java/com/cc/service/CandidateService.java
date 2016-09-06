package com.cc.service;

import com.cc.constants.SysCanstants;
import com.cc.constants.VoteErrorEnum;
import com.cc.exception.BizException;
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
        logger.info("add candidate:{}", candidate);
        Assert.notNull(candidate, "add -candidate should not be null");


        candidateMapper.insert(candidate);
    }

    public int optimisticUpdateCandidate(Candidate candidate) {
        logger.info("optimistic update candidate:{}", candidate);
        for (int i = 1; i <= SysCanstants.RETRY_TIMES; i++) {
            Candidate candidate1 = candidateMapper.selectByPrimaryKey(candidate.getId());
            int votes = candidate1.getVotes() == null ? 0 : candidate1.getVotes();
            candidate1.setVotes(votes + 1);
            int result = candidateMapper.update(candidate1);
            if (result == 1) {
                return 1;
            }
        }
        return 0;
    }

    public int pessimisticUpdateCandidate(Candidate candidate) {
        logger.info("pessimistic update candidate:{}", candidate);
        for (int i = 1; i <= SysCanstants.RETRY_TIMES; i++) {
            Candidate candidate1 = candidateMapper.selectByPrimaryKeyForlock(candidate.getId());
            int votes = candidate1.getVotes() == null ? 0 : candidate1.getVotes();
            candidate1.setVotes(votes + 1);
            int result = candidateMapper.update(candidate1);
            if (result == 1) {
                return 1;
            }
        }
        return 0;
    }

    public List<Candidate> findAll() {
        List<Candidate> candidates = candidateMapper.findAll();
        return candidates;
    }

    public void vote(Candidate candidate) {
        Assert.notNull(candidate, "vote -candidate should not be null");
        if (optimisticUpdateCandidate(candidate) == 1) {
            logger.info("vote success");
            return;
        } else {
            int result = pessimisticUpdateCandidate(candidate);
            if (result == 0) {
                logger.error("vote for candidate-{} failed", candidate);
                throw new BizException(VoteErrorEnum.VOTE_FAILED.getMsg());
            }
        }
    }

    public void deleteCandidate(Integer candidateId) {
        Assert.notNull(candidateId, "delete -candidateId should not be null");
        int res = candidateMapper.deleteCandidateById(candidateId);
        if (res != 1) {
            throw new BizException(String.format(VoteErrorEnum.DELETE_ERROR.getMsg(), candidateId));
        }
    }

    public void groupDelete(List<Integer> candidateIds) {
        int res = 0;
        if (candidateIds != null && !candidateIds.isEmpty()) {
            res = candidateMapper.groupDelete(candidateIds);
        }
        if (res <= 0) {
            throw new BizException("删除失败");
        }
    }
}
