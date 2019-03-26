package org.lc.springboot.service.imple;

import lombok.extern.slf4j.Slf4j;
import org.lc.springboot.dao.mapper.StudentMapper;
import org.lc.springboot.entity.pojo.DO.StudentDO;
import org.lc.springboot.entity.pojo.DTO.StudentDTO;
import org.lc.springboot.entity.pojo.QO.StudentQuery;
import org.lc.springboot.exception.BizException;
import org.lc.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j()
public class StudentServiceImpl implements StudentService {
    private StudentMapper studentMapper;

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Cacheable(key = "#id", value = "studentDTO")
    @Override
    public StudentDTO getStudentById(int id) {
        StudentDO student = studentMapper.getStudentById(id);
        if (student == null) {
            log.warn("查询不到学生信息，ID：{}", id);
            throw new BizException("查询不到信息");
        }
        StudentDTO dto = new StudentDTO();
        dto.setName(student.getName());
        dto.setAge(student.getAge());
        return dto;
    }

    @Transactional
    @Override
    public boolean updateStudentById(StudentQuery query) {
        int result = studentMapper.updateStudentById(query);
        if (result == 1) {
            throw new BizException("test");
        }
        return result > 0;
    }
}
