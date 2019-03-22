package org.lc.springboot.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.lc.springboot.entity.pojo.VO.SpringBootBaseResultVO;
import org.lc.springboot.exception.BizException;
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
    public SpringBootBaseResultVO handle(Exception e) {
        log.warn("系统异常", e);
        return SpringBootBaseResultVO.error();
    }

    /**
     * 拦截业务异常
     * @param e 业务异常
     * @return 统一返回格式
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public SpringBootBaseResultVO handleBizException(BizException e) {
        return new SpringBootBaseResultVO(400, e.getMessage());
    }

    /**
     * 拦截参数校验错误异常
     * @param e 参数校验异常
     * @return 统一返回格式
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public SpringBootBaseResultVO handleArgumentNotValidException(MethodArgumentNotValidException e) {
        String msg = null;
        FieldError error = e.getBindingResult().getFieldError();
        if (error != null) {
            msg = error.getDefaultMessage();
        }
        log.warn("参数校验异常,{}", msg);
        return new SpringBootBaseResultVO(400, msg);
    }

    @ExceptionHandler(value = UnauthenticatedException.class)
    @ResponseBody
    public SpringBootBaseResultVO handleUnauthenticatedException() {
        String msg = "权限不足";
        log.warn(msg);
        return new SpringBootBaseResultVO(400, msg);
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseBody
    public SpringBootBaseResultVO handleUnauthorizedException() {
        String msg = "权限条目不存在";
        log.warn(msg);
        return new SpringBootBaseResultVO(400, msg);
    }

    @ExceptionHandler(value = AuthenticationException.class)
    @ResponseBody
    public SpringBootBaseResultVO handleAuthenticationException() {
        String msg = "身份认证失败";
        log.warn(msg);
        return new SpringBootBaseResultVO(400, msg);
    }
}
