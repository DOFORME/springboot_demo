package org.lc.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.lc.springboot.entity.pojo.DTO.StudentDTO;
import org.lc.springboot.entity.pojo.QO.StudentQuery;
import org.lc.springboot.entity.pojo.QO.group.StudentUpdateById;
import org.lc.springboot.entity.pojo.VO.SpringBootBaseResultVO;
import org.lc.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
@Validated
@Slf4j
public class StudentController {
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public SpringBootBaseResultVO getStudentById(@PathVariable int id) {
        StudentDTO dto = studentService.getStudentById(id);
        return SpringBootBaseResultVO.ok(dto);
    }

    @PutMapping("putStudent")
    public SpringBootBaseResultVO updateStudentById(@Validated(StudentUpdateById.class) @RequestBody StudentQuery query) {
        boolean result = studentService.updateStudentById(query);
        return SpringBootBaseResultVO.ok(result);
    }

    @GetMapping("test")
    public SpringBootBaseResultVO test() {
        return SpringBootBaseResultVO.ok();
    }
}
