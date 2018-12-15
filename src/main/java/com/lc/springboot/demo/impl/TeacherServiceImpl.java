package com.lc.springboot.demo.impl;

import com.lc.springboot.demo.dao.jpa.TeacherJpaDao;
import com.lc.springboot.demo.entity.pojo.Teacher;
import com.lc.springboot.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lc
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherJpaDao teacherJpaDao;

    @Override
    public Teacher findById(int id) {
        Teacher teacher = teacherJpaDao.getById(id);
        System.out.println(teacher);
        return teacher;
    }
}
