package com.lc.springboot.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class MyAspect {

    private static final Logger logger = LoggerFactory.getLogger(MyAspect.class);

    private int test = 0;

    private ThreadLocal<Long> t = new ThreadLocal<>();

    @Pointcut("execution(public * com.lc.springboot.demo.controller.StudentController.*(..))")
    public void start() {
        logger.info("===========my aspect==========");
//        logger.info("请求地址" + request.getRequestURL());
        System.out.println(test);
        System.out.println(t.get());
        t.set(System.currentTimeMillis());
        test += 1;
    }

    @After("execution(public * com.lc.springboot.demo.controller.StudentController.*(..))")
    public void finish() {
        System.out.println("=======finish========");
        System.out.println(test);
        System.out.println(t.get());
    }

    @Before("start()")
    public void log() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={}", request.getRequestURI());
    }
}
