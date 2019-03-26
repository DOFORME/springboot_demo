package org.lc.springboot.service;

import org.lc.springboot.entity.pojo.DTO.StudentDTO;
import org.lc.springboot.entity.pojo.QO.StudentQuery;
import org.springframework.transaction.annotation.Transactional;

public interface StudentService {

    StudentDTO getStudentById(int id);

    boolean updateStudentById(StudentQuery query);
}
