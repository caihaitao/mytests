package com.cc.service;

import com.cc.mapper.VoteRecordMapper;
import com.cc.model.VoteRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
@Service
public class VoteRecordService {
    private static final Logger logger = LoggerFactory.getLogger(VoteRecordService.class);
    @Autowired
    private VoteRecordMapper voteRecordMapper;

    public List<VoteRecord> findAll() {
        logger.info("vote record find all");
        List<VoteRecord> voteRecords = voteRecordMapper.findAll();
        logger.info("vote record find all return {} items",voteRecords.size());
        return voteRecords;
    }

    public void addRecord(VoteRecord voteRecord) {
        logger.info("vote record add : {}",voteRecord);
        Assert.notNull(voteRecord,"add-vote record should not be null");
        voteRecordMapper.addRecord(voteRecord);
    }

    public VoteRecord selectByMobileAndDate(String mobile, Date date) {
        logger.info("vote selectByMobileAndDate :mobile-{},date-{}",mobile,date);
        return voteRecordMapper.selectByMobileAndDate(mobile,date);
    }
}
