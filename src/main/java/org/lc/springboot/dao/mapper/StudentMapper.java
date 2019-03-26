package org.lc.springboot.dao.mapper;

import org.lc.springboot.entity.pojo.DO.StudentDO;
import org.lc.springboot.entity.pojo.QO.StudentQuery;
import org.springframework.stereotype.Component;

@Component
public interface StudentMapper {
    StudentDO getStudentById(int id);

    int updateStudentById(StudentQuery query);
}
