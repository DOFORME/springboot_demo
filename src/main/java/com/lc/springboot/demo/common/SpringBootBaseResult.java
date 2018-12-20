package com.lc.springboot.demo.common;

import lombok.Data;

/**
 * 统一返回对象
 * @author lc
 * @date 2018-12-13 23:41:15
 * @version 1.0.0
 */
@Data
public class SpringBootBaseResult<T extends Object>  {

    private final Integer status;

    private final String msg;

    private final T data;

    private final Long time;


    private SpringBootBaseResult() {
        this.status = Code.SUCCESS.getCode();
        this.msg = Code.SUCCESS.getMsg();
        this.data = null;
        this.time = System.currentTimeMillis();
    }

    public SpringBootBaseResult(Code code) {
        this.status = code.getCode();
        this.msg = code.getMsg();
        this.data = null;
        this.time = System.currentTimeMillis();
    }

    public SpringBootBaseResult(Code code, T data) {
        this.status = code.getCode();
        this.msg = code.getMsg();
        this.data = data;
        this.time = System.currentTimeMillis();
    }

    public SpringBootBaseResult(int status, String msg) {
        this.status = status;
        this.msg = msg;
        this.data = null;
        this.time = System.currentTimeMillis();
    }

    public SpringBootBaseResult(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.time = System.currentTimeMillis();
    }

    public static SpringBootBaseResult ok() {
        return new SpringBootBaseResult();
    }

    public static SpringBootBaseResult ok(Object data) {
        return new SpringBootBaseResult<>(Code.SUCCESS.getCode(), Code.SUCCESS.getMsg(), data);
    }

    public static SpringBootBaseResult failed() {
        return new SpringBootBaseResult(Code.FAILED.getCode(), Code.FAILED.getMsg());
    }

    public static SpringBootBaseResult error() {
        return new SpringBootBaseResult(Code.SERVER_ERROR.getCode(), Code.SERVER_ERROR.getMsg());
    }
}
