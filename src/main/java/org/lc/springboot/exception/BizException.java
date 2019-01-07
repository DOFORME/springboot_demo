package org.lc.springboot.exception;

import org.lc.springboot.common.Code;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义业务异常
 * demo 框架只对runtime exception进行事务回滚
 * @author Administrator
 * @date 2018-12-14 09:25:36
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
public class BizException extends RuntimeException {

    private Integer code;

    public BizException(Code code, String msg) {
        super(msg);
        this.code = code.getCode();
    }

    public BizException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
