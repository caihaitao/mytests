package com.cc.constants;

/**
 * Created by Administrator on 2016/8/18.
 */
public enum VoteErrorEnum {
    ALREADY_VOTE (1,"今天已参与投票"),
    SYSTEM_ERROR (2,"系统内部异常"),
    ;

    private int type;
    private String msg;

    VoteErrorEnum(int type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public int getType() {
        return type;
    }

    public String getMsg() {
        return msg;
    }
}
