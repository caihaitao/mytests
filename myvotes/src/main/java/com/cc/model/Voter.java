package com.cc.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/13.
 */
public class Voter implements Serializable {
    private String name;
    private String ip;
    private String mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Voter(String name, String ip, String mobile) {
        this.name = name;
        this.ip = ip;
        this.mobile = mobile;
    }
}
