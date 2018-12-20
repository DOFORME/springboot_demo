package com.lc.springboot.demo.service;

import com.lc.springboot.demo.entity.pojo.Teacher;

/**
 * @author lc
 */
public interface TeacherService {

    /**
     * 根据ID查询教师信息
     * @param id id
     * @return 教师信息
     */
    Teacher findById(int id);

    /**
     * 保存教师信息
     * @param teacher 教师信息
     * @return 带ID的教师信息
     */
    Teacher save(Teacher teacher);

    void validTest(String msg);
}
