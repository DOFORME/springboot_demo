package com.lc.springboot.demo.service;

import com.lc.springboot.demo.entity.pojo.Teacher;

/**
 * @author lc
 */
public interface TeacherService {

    Teacher findById(int id);
}
