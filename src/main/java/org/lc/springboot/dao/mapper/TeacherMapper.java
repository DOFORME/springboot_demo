package org.lc.springboot.dao.mapper;

import org.lc.springboot.entity.pojo.DO.TeacherDO;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherMapper {

    TeacherDO getTeacherById(int id);
}
