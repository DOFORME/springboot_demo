package com.lc.springboot.demo.service;

import com.lc.springboot.demo.entity.pojo.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceImplTest {

    private TeacherService teacherService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @Test
    public void setTeacherJpaDao() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void save() {
        Teacher teacher = new Teacher();
        teacher.setName("bob");
        teacherService.save(null);
    }

    @Test
    public void valid() {
        teacherService.validTest("saghk");
    }
}