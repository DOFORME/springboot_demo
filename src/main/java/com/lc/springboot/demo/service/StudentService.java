package com.lc.springboot.demo.service;

import com.lc.springboot.demo.entity.pojo.Student;

import javax.validation.constraints.Min;
import java.util.List;

/**
 * 学生业务接口
 * @author lc
 * @date 2018-12-12 21:32:44
 * @version 1.0.0
 */
public interface StudentService {

    /**
     * 保存学生信息
     * @param student 学生信息实体
     * @return 保存结果
     */
    boolean save(Student student);

    void saveSelective(Student student);

    int saveStudentList(List<Student> students);

    int saveStudentAndReturnKey(Student student);

    boolean saveStudentBaseInfo(Student student);

    boolean saveOrUpdate(Student student);

    boolean saveExistIgnore(Student student);

    boolean saveOrReplace(Student student);

    boolean saveWithDynamicSql(Student student);

    boolean delete(int id);

    boolean updateAgeById(Student student);

    boolean updateAndReturnPrimaryKey(Student student);

    Student get(int id);

    List<Student> getSameNameAndAgeStudent(String name, int age);

    int selectOldestStudent();

    Student getStudentBaseInfo(int id);

    void validate(@Min(1) int age);
}
