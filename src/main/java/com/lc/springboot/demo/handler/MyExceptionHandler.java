package com.lc.springboot.demo.handler;

import com.lc.springboot.demo.common.SpringBootBaseResult;
import com.lc.springboot.demo.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常拦截
 * @author lc
 * @date 2018-12-14 09:11:31
 * @version 1.0.0
 * @since 1.0.0
 */
@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    /**
     * 拦截未知异常
     * @param e 未知异常
     * @return 统一返回格式
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public SpringBootBaseResult handle(Exception e) {
        log.warn("系统异常", e);
        return SpringBootBaseResult.error();
    }

    /**
     * 拦截业务异常
     * @param e 业务异常
     * @return 统一返回格式
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public SpringBootBaseResult handleBizException(BizException e) {
        log.warn("业务异常处理", e);
        return new SpringBootBaseResult(400, e.getMessage());
    }

    /**
     * 拦截参数校验错误异常
     * @param e 参数校验异常
     * @return 统一返回格式
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public SpringBootBaseResult handleArgumentNotValidException(MethodArgumentNotValidException e) {
        String msg = null;
        FieldError error = e.getBindingResult().getFieldError();
        if (error != null) {
            msg = error.getDefaultMessage();
        }
        log.warn("参数校验异常,{}", msg);
        return new SpringBootBaseResult(400, msg);
    }

}
