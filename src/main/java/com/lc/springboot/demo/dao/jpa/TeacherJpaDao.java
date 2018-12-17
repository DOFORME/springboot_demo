package com.lc.springboot.demo.dao.jpa;

import com.lc.springboot.demo.entity.pojo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lc
 */
public interface TeacherJpaDao extends JpaRepository<Teacher, Long> {

    /**
     * 根据ID查询教师信息
     * @param id ID
     * @return 教师实体
     */
    Teacher getById(int id);

}
