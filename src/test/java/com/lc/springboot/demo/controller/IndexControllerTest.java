package com.lc.springboot.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/* 如果测试类的包结构与被测试的类不一样，那么SpringBootTest注解就需要配置Application */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexControllerTest {

    @Test
    public void toIndex() {
        System.out.println(" test ");
    }
}