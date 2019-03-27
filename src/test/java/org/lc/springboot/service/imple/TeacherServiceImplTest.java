package org.lc.springboot.service.imple;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lc.springboot.entity.pojo.DTO.TeacherDTO;
import org.lc.springboot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TeacherServiceImplTest {
    @Autowired
    private TeacherService teacherService;

    @Test
    public void getTeacherById() {
        TeacherDTO dto = teacherService.getTeacherById(1);
        log.info(new Gson().toJson(dto));
    }
}