package org.lc.springboot.dao.jpa;

import org.lc.springboot.entity.pojo.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherJpaDaoTest {

    private TeacherJpaDao teacherJpaDao;

    @Autowired
    public void setTeacherJpaDao(TeacherJpaDao teacherJpaDao) {
        this.teacherJpaDao = teacherJpaDao;
    }

    @Test
    public void saveTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName("abc");
        Teacher result = teacherJpaDao.save(teacher);
        System.out.println(result);
    }

}