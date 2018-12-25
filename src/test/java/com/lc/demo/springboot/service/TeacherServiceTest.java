package com.lc.demo.springboot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void findById() {
//        teacherService.findById(1);
    }
}