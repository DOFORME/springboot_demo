package org.lc.springboot.controller;

import org.lc.springboot.common.SpringBootBaseResult;
import org.lc.springboot.entity.pojo.Student;
import org.lc.springboot.service.StudentService;
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

    /**
     * 保存学生信息
     * @param student 学生信息
     * @return 保存结果
     */
    @RequestMapping(value = "save", method = {RequestMethod.POST})
    public SpringBootBaseResult save(@Validated(value = {Student.SaveValidate.class}) @RequestBody Student student) {
        studentService.save(student);
        return SpringBootBaseResult.ok();
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public SpringBootBaseResult getStudentById(@RequestParam("id") int id) {
        Student student = studentService.get(id);
        return new SpringBootBaseResult<>(200, "success", student);
    }

}
