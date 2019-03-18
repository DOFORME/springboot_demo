package org.lc.springboot.dao.jpa;

import org.lc.springboot.entity.pojo.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassJpaDao extends JpaRepository<Clazz, Long> {
    /**
     * 通过年级号和班级号查询班级信息
     * @param grade 年级号
     * @param no 班级号
     * @return 班级信息
     */
    Clazz getClazzByGradeAndNo(int grade, int no);
}
