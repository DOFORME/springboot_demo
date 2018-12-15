package com.lc.springboot.demo.dao.jpa;

import com.lc.springboot.demo.entity.pojo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lc
 */
public interface TeacherJpaDao extends JpaRepository<Teacher, Long> {

    Teacher getById(int id);
}
