package com.lc.springboot.demo2;

import com.google.gson.Gson;
import com.lc.springboot.demo.dao.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@WebAppConfiguration
public class StudentTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testJunit() {
        System.err.println(" === junit is running === ");
    }

    @Test
    public void getStudent() {
        Gson json = new Gson();
        System.err.println(" =========== ");
    }
}
