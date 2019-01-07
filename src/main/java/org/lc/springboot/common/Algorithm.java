package org.lc.springboot.common;

/**
 * 算法名枚举类
 */
public enum Algorithm {
    // MD5算法
    MD5(1, "MD5"),
    BASE64(2, "BASE64")
    ;

    /**
     * 代码
     */
    private int code;

    /**
     * 信息
     */
    private String msg;
    private Algorithm(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }}
