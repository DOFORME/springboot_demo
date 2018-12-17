package com.lc.springboot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主界面
 * @author lc
 * @date 2018-12-17 16:08:25
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/index", method = RequestMethod.GET)
public class IndexController {

    /**
     * 欢迎界面
     * @return 欢迎信息
     */
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String toIndex() {
        return "hello spring boot";
    }
}
