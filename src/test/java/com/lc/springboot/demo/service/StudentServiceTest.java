package com.lc.springboot.demo.service;

import com.google.gson.Gson;
import com.lc.springboot.demo.entity.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;


    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceTest.class);

    @Test
    @Rollback()
    public void save() {
        Student student = new Student();
        student.setName("test");
        student.setAge(18);
        student.setGender("man");
        student.setAddress("nan jing");
        student.setCreateAt(LocalDateTime.now());
        student.setCreateBy("admin");
        student.setDelete(false);
        studentService.save(student);

        Student student2 = new Student();
        student2.setName("test2");
        student2.setAge(20);
        student2.setGender("man");
        student2.setAddress("nan jing");
        student2.setCreateAt(LocalDateTime.now());
        student2.setCreateBy("admin");
        student2.setDelete(false);
        studentService.save(student2);
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
        System.out.println(studentService.delete(6));
    }

    @Test
    public void update() {

    }

    @Test
    public void get() {
        int id = 1;
        Student s = studentService.get(id);
        LOGGER.info(new Gson().toJson(s));

        Student s2 = studentService.get(id);
        LOGGER.info(new Gson().toJson(s2));
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
        Student student = studentService.getStudentBaseInfo(2);
        System.out.println(new Gson().toJson(student));
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

    @Test
    public void validate() {
        studentService.validate(0);
    }

    @Test
    public void saveOrUpdate() {
        Student student = new Student();
        student.setId(1);
        student.setName("bob");
        student.setAge(12);
        System.out.println(studentService.saveOrUpdate(student));
    }

    @Test
    public void saveExistIgnore() {
        Student student = new Student();
        student.setId(1);
        student.setName("ignore");
        System.out.println(studentService.saveExistIgnore(student));
    }

    @Test
    public void saveOrReplace() {
        Student student = new Student();
        student.setId(1);
        student.setName("ignore");
        System.out.println(studentService.saveOrReplace(student));
    }

    @Test
    public void saveWithDynamicSql() {
        Student student = new Student();
        student.setName("dynamic2");
        student.setAge(100);
        System.out.println(studentService.saveWithDynamicSql(student));
    }

}