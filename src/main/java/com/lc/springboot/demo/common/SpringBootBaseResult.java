package com.lc.springboot.demo.common;

import lombok.Data;

/**
 * 统一返回对象
 * @author lc
 * @date 2018-12-13 23:41:15
 * @version 1.0.0
 */
@Data
public class SpringBootBaseResult<T>  {

    private final Integer status;

    private final String msg;

    private final T data;

    private final Long time;


    private SpringBootBaseResult() {
        this.status = 200;
        this.msg = "success";
        this.data = null;
        this.time = System.currentTimeMillis();
    }

    public SpringBootBaseResult(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.time = System.currentTimeMillis();
    }

    public static SpringBootBaseResult ok() {
        return new SpringBootBaseResult();
    }

    public static SpringBootBaseResult fail() {
//        return new SpringBootBaseResult()
        return null;
    }
}
