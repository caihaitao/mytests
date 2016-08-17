package com.cc.service;

import com.cc.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/8/17.
 */
public class VoteRecordServiceTest extends BaseTest {
    @Autowired
    private VoteRecordService voteRecordService;

    @Test
    public void testRecord() {
        voteRecordService.findAll();
    }
}
