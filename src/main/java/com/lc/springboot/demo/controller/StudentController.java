package com.lc.springboot.demo.controller;

import com.lc.springboot.demo.common.SpringBootBaseResult;
import com.lc.springboot.demo.entity.pojo.Student;
import com.lc.springboot.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 学生controller
 * @author lc
 * @date 2018-12-13 20:58:37
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "save", method = {RequestMethod.POST})
    @ResponseBody
    public SpringBootBaseResult save(@Validated(value = {Student.SaveValidate.class}) @RequestBody Student student) {
        studentService.save(student);
        return SpringBootBaseResult.ok();
    }

}
