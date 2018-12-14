package com.lc.springboot.demo.exception;

import com.lc.springboot.demo.common.Code;
import lombok.Data;

/**
 * 自定义业务异常
 * spring 框架只对runtime exception进行事务回滚
 * @author Administrator
 * @date 2018-12-14 09:25:36
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class BizException extends RuntimeException {

    private Code code;

    private String msg;

    public BizException(Code code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
