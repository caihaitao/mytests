package com.cc.model;

import java.util.Date;

/**
 * Created by Administrator on 2016/8/15.
 */
public class VoteRecord {
    private Integer id;
    private String mobile;
    private String name;
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

    public String getName() {
        return name;
    }

    public VoteRecord setName(String name) {
        this.name = name;
        return this;
    }

    public VoteRecord(String mobile, String name, String ip) {
        this.mobile = mobile;
        this.name = name;
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "VoteRecord{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", lastVoteDate=" + lastVoteDate +
                ", ip='" + ip + '\'' +
                '}';
    }
}
