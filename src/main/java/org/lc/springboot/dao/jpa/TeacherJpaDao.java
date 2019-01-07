package org.lc.springboot.dao.jpa;

import org.lc.springboot.entity.pojo.Teacher;
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
