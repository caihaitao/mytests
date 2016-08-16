package com.cc.mapper;

import com.cc.model.VoteRecord;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
@Repository
public interface VoteRecordMapper {
    List<VoteRecord> findAll();

    int addRecord(VoteRecord voteRecord);

    VoteRecord selectByMobileAndDate(String mobile,LocalDate date);
}
