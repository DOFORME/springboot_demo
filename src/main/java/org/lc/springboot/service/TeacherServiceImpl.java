package org.lc.springboot.service;

import org.lc.springboot.dao.jpa.TeacherJpaDao;
import org.lc.springboot.entity.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;

/**
 * @author lc
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherJpaDao teacherJpaDao;

    @Autowired
    public void setTeacherJpaDao(TeacherJpaDao teacherJpaDao) {
        this.teacherJpaDao = teacherJpaDao;
    }

    @Override
    public Teacher findById(int id) {
        Teacher teacher = teacherJpaDao.getById(id);
        System.out.println(teacher);
        return teacher;
    }

    @Override
    public Teacher save(Teacher teacher) {
        System.out.println("test is right");
        return null;
    }


    @Override
    public void validTest(@Size(max = 2) String msg) {
        System.out.println("test");
    }

}