package com.lc.springboot.demo.exception;

/**
 * spring 框架只对runtime exception进行事务回滚
 */
public class BizException extends RuntimeException {

    private Integer code;

    public BizException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
