package com.cc.model;

import java.util.Date;

/**
 * Created by Administrator on 2016/8/15.
 */
public class VoteRecord {
    private Integer id;
    private String mobile;
    private Date lastVoteDate;
    private String ip;

    public Integer getId() {
        return id;
    }

    public VoteRecord setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public VoteRecord setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public Date getLastVoteDate() {
        return lastVoteDate;
    }

    public VoteRecord setLastVoteDate(Date lastVoteDate) {
        this.lastVoteDate = lastVoteDate;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public VoteRecord setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public VoteRecord() {
    }

    public VoteRecord(String mobile, Date lastVoteDate, String ip) {
        this.mobile = mobile;
        this.lastVoteDate = lastVoteDate;
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "VoteRecord{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", lastVoteDate=" + lastVoteDate +
                ", ip='" + ip + '\'' +
                '}';
    }
}
