package com.cc.mapper;

import com.cc.model.VoteRecord;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
public interface VoteRecordMapper {
    List<VoteRecord> findAll();

    int addRecord(VoteRecord voteRecord);

    VoteRecord selectByMobileAndDate(@Param("mobile") String mobile, @Param("date") Date date);

    VoteRecord selectByIpAndDate(@Param("ip") String ip, @Param("today")  Date today);
}
