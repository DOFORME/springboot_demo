package com.lc.springboot.demo.impl;

import com.google.gson.Gson;
import com.lc.springboot.demo.dao.StudentMapper;
import com.lc.springboot.demo.entity.pojo.Student;
import com.lc.springboot.demo.exception.BizException;
import com.lc.springboot.demo.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * 学生相关业务类.
 */
@Service("studentService")
@Validated
public class StudentServiceImpl implements StudentService {

    private static Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentMapper studentMapper;

    public void save(Student student) {
        int result = studentMapper.save(student);
        logger.info("student save result is : {}", result);
    }

    public void saveSelective(Student student) {
        int result = studentMapper.saveSelective(student);
        logger.info("student save result is : {}", result);
    }

    @Override
    public int saveStudentList(List<Student> students) {
        if (students == null || students.size() == 0) {
            return 0;
        }
        return studentMapper.saveStudentList(students);
    }

    @Override
    public int saveStudentAndReturnKey(Student student) {
        if (student == null) {
            return 0;
        }
        return studentMapper.saveStudentAndReturnKey(student);
    }

    @Override
    public boolean saveStudentBaseInfo(Student student) {
        if (student == null) {
            return false;
        }
        if (student.getName() == null || student.getAge() == null || student.getGender() == null) {
            return false;
        }
        return studentMapper.saveStudentBaseInfo(student) > 0;
    }

    @Override
    public boolean saveOrUpdate(Student student) {
        int result = studentMapper.saveOrUpdate(student);
        return result > 0;
    }

    @Override
    public boolean saveExistIgnore(Student student) {
        int result = studentMapper.saveExistIgnore(student);
        return result > 0;
    }

    @Override
    public boolean saveOrReplace(Student student) {
        int result = studentMapper.saveOrReplace(student);
        return result > 0;
    }

    @Override
    public boolean saveWithDynamicSql(Student student) {
        int result = studentMapper.saveWithDynamicSql(student);
        return result > 0;
    }

    @Override
    public boolean delete(int id) {
        if (id < 1) {
            return false;
        }
        int result = studentMapper.delete(id);
        System.out.println(result);
        return result > 0;
    }

    @Override
    public boolean updateAgeById(Student student) {
        if (student == null) {
            return false;
        }
        if (student.getId() == null || student.getId() < 1) {
            return false;
        }
        if (student.getAge() == null || student.getAge() < 1) {
            return false;
        }
        return studentMapper.updateAgeById(student) > 0;
    }

    @Override
    public boolean updateAndReturnPrimaryKey(Student student) {
        if (student == null || student.getAge() == null || student.getAge() < 1) {
            return false;
        }
        int result = studentMapper.updateAndReturnPrimaryKey(student);
        System.out.println(result);
        System.out.println(student.getId());
        return true;
    }

    public Student get(int id) {
        if (id <= 0) {
            throw new BizException(400, "student id is null");
        }
        return studentMapper.get(id);
    }

    public List<Student> getSameNameAndAgeStudent(String name, int age) {
        if (StringUtils.isBlank(name)) {
            throw new BizException(400, "name is null");
        }
        if (age <= 0) {
            throw new BizException(400, "age is error");
        }
        return studentMapper.getSameNameAndAgeStudent(name, age);
    }

    public int selectOldestStudent() {
        return studentMapper.getOldestStudent();
    }

    public Student getStudentBaseInfo(int id) {
        if (id < 0) {
            return null;
        }
        Student student = studentMapper.getStudentBaseInfo(id);
        logger.info(new Gson().toJson(student));
        return student;
    }

    public void validate(int age) {
        System.out.println("validate test");
    }
}
