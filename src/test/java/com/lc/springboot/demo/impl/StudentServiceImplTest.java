package com.lc.springboot.demo.impl;

import com.google.gson.Gson;
import com.lc.springboot.demo.entity.pojo.Student;
import com.lc.springboot.demo.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;


    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImplTest.class);

    @Test
    public void save() {
        Student student = new Student();
        student.setName("test");
        student.setAge(100);
        student.setGender("man");
        student.setAddress("nan jing");
        student.setCreateAt(LocalDateTime.now());
        student.setCreateBy("admin");
        student.setDelete(false);
        studentService.save(student);
    }

    @Test
    public void saveSelective() {
        Student student = new Student();
        student.setName("test");
        student.setAge(100);
        studentService.saveSelective(student);
    }

    @Test
    public void saveStudentList() {
        List<Student> students = new ArrayList<>(2);
        Student student = new Student();
        student.setName("test");
        student.setAge(100);
        student.setGender("man");
        student.setAddress("nan jing");
        student.setCreateAt(LocalDateTime.now());
        student.setCreateBy("admin");
        student.setDelete(false);
        students.add(student);
        Student student2 = new Student();
        student.setName("test2");
        student.setAge(100);
        student.setGender("man");
        student.setAddress("nan jing");
        student.setCreateAt(LocalDateTime.now());
        student.setCreateBy("admin");
        student.setDelete(false);
        students.add(student2);
        int result = studentService.saveStudentList(students);
        System.out.println(result);
    }

    @Test
    public void saveStudentAndReturnKey() {
        Student student = new Student();
        student.setName("test");
        student.setAge(100);
        student.setGender("man");
        student.setAddress("new york");
        student.setCreateAt(LocalDateTime.now());
        student.setCreateBy("admin");
        student.setDelete(false);
        System.out.println(student.getId());
        int key = studentService.saveStudentAndReturnKey(student);
        System.out.println(student.getId());
        System.out.println(key);
    }

    @Test
    public void delete() {
        studentService.delete(6);
    }

    @Test
    public void update() {

    }

    @Test
    public void get() {
        int id = 2;
        Student s = studentService.get(id);
        LOGGER.info(new Gson().toJson(s));
    }

    @Test
    public void getSameNameAndAgeStudent() {
        List<Student> students = studentService.getSameNameAndAgeStudent("alice", 12);
        LOGGER.info("name is {} and age is {} has those:{}", "alice", 12, new Gson().toJson(students));
    }


    @Test
    public void selectOldestStudent() {
        LOGGER.info("the oldest student age is: {}", studentService.selectOldestStudent());
    }


    @Test
    public void getStudentBaseInfo() {
        studentService.getStudentBaseInfo(2);
    }


    @Test
    public void saveStudentBaseInfo() {
        Student student = new Student();
        student.setName("liu");
        student.setAge(23);
        student.setGender("man");
        boolean result = studentService.saveStudentBaseInfo(student);
        System.out.println(result);
    }

    @Test
    public void updateAgeById() {
        Student student = new Student();
        student.setId(1);
        student.setAge(100);
        boolean result = studentService.updateAgeById(student);
        System.out.println(result);
    }

    @Test
    public void updateAndReturnPrimaryKey() {
        Student student = new Student();
        student.setAge(100);
        student.setName("张三");
        System.out.println(studentService.updateAndReturnPrimaryKey(student));
    }
}