package com.cc.exception;

/**
 * Created by Administrator on 2016/8/16.
 */
public class BizException extends RuntimeException {

    public BizException() {
        super();
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(String message) {
        super(message);
    }

}
