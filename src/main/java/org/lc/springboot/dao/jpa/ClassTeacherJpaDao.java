package org.lc.springboot.dao.jpa;

import org.lc.springboot.entity.pojo.ClassTeacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassTeacherJpaDao extends JpaRepository<ClassTeacher, Long> {

    /**
     * 查询班级-教师信息
     * @param id 班级id
     * @return 班级-教师信息
     */
    List<ClassTeacher> queryByClassId(int id);
}
