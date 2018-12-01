package com.lc.springboot.demo.service;

import com.lc.springboot.demo.entity.pojo.Student;

import java.util.List;

public interface StudentService {

    void save(Student student);

    void saveSelective(Student student);

    int saveStudentList(List<Student> students);

    int saveStudentAndReturnKey(Student student);

    boolean saveStudentBaseInfo(Student student);

    boolean delete(int id);

    boolean updateAgeById(Student student);

    boolean updateAndReturnPrimaryKey(Student student);

    Student get(int id);

    List<Student> getSameNameAndAgeStudent(String name, int age);

    int selectOldestStudent();

    Student getStudentBaseInfo(int id);
}
