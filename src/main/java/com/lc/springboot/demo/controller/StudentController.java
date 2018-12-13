package com.lc.springboot.demo.controller;

import com.google.gson.Gson;
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
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "save", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public SpringBootBaseResult save(@Validated(value = {Student.SaveValidate.class, Student.UpdateValidate.class}) @RequestBody Student student) {
        System.err.println(new Gson().toJson(student));
        return SpringBootBaseResult.ok();
    }

}
