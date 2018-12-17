package com.lc.springboot.demo.controller;

import com.lc.springboot.demo.common.SpringBootBaseResult;
import com.lc.springboot.demo.entity.pojo.Teacher;
import com.lc.springboot.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lc
 * @date 2018-12-17 17:21:55
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("teacher")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public SpringBootBaseResult save(Teacher teacher) {
        teacherService.save(teacher);
        return SpringBootBaseResult.ok();
    }


}
