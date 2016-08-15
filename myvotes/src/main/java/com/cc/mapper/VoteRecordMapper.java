package com.cc.mapper;

import com.cc.model.VoteRecord;

import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
public interface VoteRecordMapper {
    List<VoteRecord> findAll();

    int addRecord(VoteRecord voteRecord);
}
