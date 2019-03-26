package org.lc.springboot.service.imple;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lc.springboot.entity.pojo.DTO.StudentDTO;
import org.lc.springboot.entity.pojo.QO.StudentQuery;
import org.lc.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StudentServiceImplTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void getStudentById() {
        StudentDTO dto = studentService.getStudentById(1);
        log.warn(new Gson().toJson(dto));
    }

    @Test
    public void updateStudentById() {
        StudentQuery query = new StudentQuery();
        query.setId(1);
        query.setName("zhangsangai");
        boolean result = studentService.updateStudentById(query);
        log.warn("修改结果：{}", result);
    }
}