package org.lc.springboot.manager;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.lc.springboot.dao.jpa.ClassJpaDao;
import org.lc.springboot.dao.jpa.ClassTeacherJpaDao;
import org.lc.springboot.dao.jpa.TeacherJpaDao;
import org.lc.springboot.dao.mapper.StudentMapper;
import org.lc.springboot.entity.pojo.ClassTeacher;
import org.lc.springboot.entity.pojo.Clazz;
import org.lc.springboot.entity.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, List> getClassInfo(int grade, int no) {
        log.debug("查询班级信息，年级：{}，班级：{}", grade, no);
        long start = System.currentTimeMillis();
        Map<String, List> data = new HashMap<>();
        Clazz clazz = classJpaDao.getClazzByGradeAndNo(grade, no);
        List<ClassTeacher> classTeachers = classTeacherJpaDao.queryByClassId(clazz.getId());
        List<Student> students = studentMapper.getStudentsByClassId(clazz.getId());
        System.out.println("====================");
        System.out.println(classTeachers.size());
        System.out.println(students.size());
        System.out.println("====================");
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start) + "ms");
        log.debug("查询结束，总耗时：{},返回数据：{}", end - start, new Gson().toJson(data));
        return data;
    }
}
