package com.lc.demo.springboot.service;

import com.google.gson.Gson;
import com.lc.demo.springboot.common.Code;
import com.lc.demo.springboot.dao.mapper.StudentMapper;
import com.lc.demo.springboot.entity.pojo.Student;
import com.lc.demo.springboot.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 学生相关业务类
 *
 * @author lc
 * @version 1.0.0
 * @date 2018-12-12 21:18:19
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    private static Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private StudentMapper studentMapper;

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean save(Student student) {
        int result = studentMapper.save(student);
        return result > 0;
    }

    @Override
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

    @Override
    public Student get(int id) {
        if (id <= 0) {
            throw new BizException(Code.FAILED, "student id is null");
        }
        return studentMapper.get(id);
    }

    @Override
    public List<Student> getSameNameAndAgeStudent(String name, int age) {
        if (StringUtils.isBlank(name)) {
            throw new BizException(Code.FAILED, "name is null");
        }
        if (age <= 0) {
            throw new BizException(Code.FAILED, "age is error");
        }
        return studentMapper.getSameNameAndAgeStudent(name, age);
    }

    @Override
    public int selectOldestStudent() {
        return studentMapper.getOldestStudent();
    }

    @Override
    public Student getStudentBaseInfo(int id) {
        if (id < 0) {
            return null;
        }
        Student student = studentMapper.getStudentBaseInfo(id);
        logger.info(new Gson().toJson(student));
        return student;
    }

    @Override
    public void validate(int age) {
        System.out.println("validate test");
    }
}
