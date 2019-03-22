package org.lc.springboot.entity.pojo.VO;

import lombok.Data;
import org.lc.springboot.common.Code;

/**
 * 统一返回对象
 * @author lc
 * @date 2018-12-13 23:41:15
 * @version 1.0.0
 */
@Data
public class SpringBootBaseResultVO<T extends Object>  {

    private final Integer status;

    private final String msg;

    private final T data;

    private final Long time;


    private SpringBootBaseResultVO() {
        this.status = Code.SUCCESS.getCode();
        this.msg = Code.SUCCESS.getMsg();
        this.data = null;
        this.time = System.currentTimeMillis();
    }

    public SpringBootBaseResultVO(Code code) {
        this.status = code.getCode();
        this.msg = code.getMsg();
        this.data = null;
        this.time = System.currentTimeMillis();
    }

    public SpringBootBaseResultVO(Code code, T data) {
        this.status = code.getCode();
        this.msg = code.getMsg();
        this.data = data;
        this.time = System.currentTimeMillis();
    }

    public SpringBootBaseResultVO(int status, String msg) {
        this.status = status;
        this.msg = msg;
        this.data = null;
        this.time = System.currentTimeMillis();
    }

    public SpringBootBaseResultVO(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.time = System.currentTimeMillis();
    }

    public static SpringBootBaseResultVO ok() {
        return new SpringBootBaseResultVO();
    }

    public static SpringBootBaseResultVO ok(Object data) {
        return new SpringBootBaseResultVO<>(Code.SUCCESS.getCode(), Code.SUCCESS.getMsg(), data);
    }

    public static SpringBootBaseResultVO failed() {
        return new SpringBootBaseResultVO(Code.FAILED.getCode(), Code.FAILED.getMsg());
    }

    public static SpringBootBaseResultVO error() {
        return new SpringBootBaseResultVO(Code.SERVER_ERROR.getCode(), Code.SERVER_ERROR.getMsg());
    }
}
