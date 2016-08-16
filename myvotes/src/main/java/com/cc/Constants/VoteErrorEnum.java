package com.cc.Constants;

/**
 * Created by Administrator on 2016/8/16.
 */
public enum VoteErrorEnum {
    ALREADY_VOTE(1,"今天已经参与投票"),
    VOTE_FAILED(2,"投票失败"),
    ;

    private int code;
    private String msg;

    VoteErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
