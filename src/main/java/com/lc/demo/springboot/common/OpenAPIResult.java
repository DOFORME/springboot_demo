package com.lc.demo.springboot.common;

import lombok.Data;

/**
 * 开放接口返回对象
 * @author lc
 * @date 2018-12-14 00:11:59
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class OpenAPIResult<T> {

    /**
     * 状态码
     */
    private final Integer status;

    /**
     * 提示信息
     */
    private final String msg;

    /**
     * 数据
     */
    private final T data;

    /**
     * 返回时间
     */
    private final Long time;

    /**
     * 前面
     */
    private final String sign;
}
