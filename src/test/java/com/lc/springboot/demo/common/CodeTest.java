package com.lc.springboot.demo.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CodeTest.class);

    @Test
    public void enumValue() {
        LOGGER.info("code of {} is {}", 200, Code.SUCCESS);
    }
}