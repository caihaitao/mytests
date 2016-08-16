package com.cc.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/15.
 */
public class VoteRecordQuery implements Serializable{
    private String mobile;
    private String ip;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
