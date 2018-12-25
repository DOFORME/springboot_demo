package com.lc.demo.springboot.common;

/**
 * 统一返回对象状态码枚举类
 * @author lc
 * @date 2018-12-13 23:42:20
 * @version 1.0.0
 */

public enum Code {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),

    /**
     * 失败
     */
    FAILED(400, "请求失败"),

    /**
     * 无用户数据
     */
    NO_USER_INFO(4001, "无此用户数据"),

    /**
     * 服务器错误
     */
    SERVER_ERROR(500, "服务器错误"),

    /**
     * 未知错误
     * 该方式可以用于国际化
     */
    UNKNOWN_ERROR(555, "UNKNOWN_ERROR");

    private Integer code;

    private String msg;

    private Code(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }}
