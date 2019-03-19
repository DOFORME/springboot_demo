package org.lc.springboot.manager;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.lc.springboot.dao.jpa.ClassJpaDao;
import org.lc.springboot.dao.jpa.ClassTeacherJpaDao;
import org.lc.springboot.dao.jpa.TeacherJpaDao;
import org.lc.springboot.dao.mapper.StudentMapper;
import org.lc.springboot.entity.ClassDTO;
import org.lc.springboot.entity.pojo.ClassTeacher;
import org.lc.springboot.entity.pojo.Clazz;
import org.lc.springboot.entity.pojo.Student;
import org.lc.springboot.entity.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 班级信息
 */
@Component
@Slf4j
public class ClassInfoManager {
    private StudentMapper studentMapper;
    private TeacherJpaDao teacherJpaDao;
    private ClassJpaDao classJpaDao;
    private ClassTeacherJpaDao classTeacherJpaDao;

    @Autowired
    public void setTeacherJpaDao(TeacherJpaDao teacherJpaDao) {
        this.teacherJpaDao = teacherJpaDao;
    }

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Autowired
    public void setClassJpaDao(ClassJpaDao classJpaDao) {
        this.classJpaDao = classJpaDao;
    }

    @Autowired
    public void setClassTeacherJpaDao(ClassTeacherJpaDao classTeacherJpaDao) {
        this.classTeacherJpaDao = classTeacherJpaDao;
    }

    /**
     * 根据班级号查询班级信息
     *
     * @param grade 年级
     * @param no    班级号
     * @return 班级信息
     */
    public ClassDTO queryClassInfo(int grade, int no) {
        log.debug("查询班级信息，年级：{}，班级：{}", grade, no);
        long start = System.currentTimeMillis();
        Clazz clazz = classJpaDao.getClazzByGradeAndNo(grade, no);
        List<ClassTeacher> classTeachers = classTeacherJpaDao.queryByClassId(clazz.getId());
        List<Teacher> teachers = new ArrayList<>();
        for (ClassTeacher ct : classTeachers) {
            Teacher teacher = teacherJpaDao.getById(ct.getTeacherId());
            teachers.add(teacher);
        }
        List<Student> students = studentMapper.getStudentsByClassId(clazz.getId());
        long end = System.currentTimeMillis();
        ClassDTO dto = new ClassDTO();
        dto.setClazz(clazz);
        dto.setStudents(students);
        dto.setTeachers(teachers);
        log.debug("查询结束，总耗时：{},返回数据：{}", end - start, new Gson().toJson(dto));
        return dto;
    }
}
