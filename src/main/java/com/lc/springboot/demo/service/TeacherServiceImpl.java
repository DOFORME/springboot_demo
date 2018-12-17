package com.lc.springboot.demo.service;

import com.lc.springboot.demo.dao.jpa.TeacherJpaDao;
import com.lc.springboot.demo.entity.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * @author lc
 */
@Service
//@Validated
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
    public Teacher save(@Valid Teacher teacher) {
        System.out.println("test is right");
        return null;
    }


    @Override
    public void validTest(@Size(max = 2) String msg) {
        System.out.println("test");
    }

}
