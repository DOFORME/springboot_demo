package org.lc.springboot.service.imple;

import lombok.extern.slf4j.Slf4j;
import org.lc.springboot.dao.mapper.TeacherMapper;
import org.lc.springboot.entity.pojo.DO.TeacherDO;
import org.lc.springboot.entity.pojo.DTO.TeacherDTO;
import org.lc.springboot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {
    private TeacherMapper teacherMapper;

    @Autowired
    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public TeacherDTO getTeacherById(int id) {
        TeacherDO teacher = teacherMapper.getTeacherById(id);
        if (teacher == null) {
            log.warn("没有查询到ID为：{}的教师", id);
            return null;
        }
        TeacherDTO dto = new TeacherDTO();
        dto.setName(teacher.getName());
        dto.setAge(teacher.getAge());
        return dto;
    }
}
