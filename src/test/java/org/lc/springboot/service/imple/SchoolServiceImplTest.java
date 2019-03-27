package org.lc.springboot.service.imple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lc.springboot.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolServiceImplTest {
    @Autowired
    private SchoolService schoolService;

    @Test
    public void testGetTeacherAndStudent() {
        schoolService.testGetTeacherAndStudent();
    }
}