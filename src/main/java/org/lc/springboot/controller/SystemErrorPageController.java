package org.lc.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class SystemErrorPageController implements ErrorController {

    @RequestMapping("/error")
    public String error(HttpServletRequest request) {
        Object o = request.getAttribute("javax.servlet.error.status_code");
        if (o == null) {
            return "/404.html";
        }
        int code = (int) o;
        log.error("自定义错误页面，错误代码：{}", code);
        switch (code) {
            case 404: return "404.html";
            case 500: return "/500.html";
            default: return "/404.html";
        }
    }

    @Override
    public String getErrorPath() {
        log.error("自定义错误页面");
        return "error";
    }
}
