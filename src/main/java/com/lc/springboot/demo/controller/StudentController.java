package com.lc.springboot.demo.controller;

import com.google.gson.Gson;
import com.lc.springboot.demo.common.SpringBootBaseResultDTO;
import com.lc.springboot.demo.entity.pojo.Student;
import com.lc.springboot.demo.entity.query.StudentQuery;
import com.lc.springboot.demo.impl.StudentServiceImpl;
import com.lc.springboot.demo.exception.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentServiceImpl studentService;

    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostMapping("msg")
    public Student getStudentMsg(@RequestBody StudentQuery query) throws Exception {
        System.out.println("msg....");
        System.out.println(new Gson().toJson(query));
        System.out.println("msg....finish");
        System.out.println("hot start test");
        throw new Exception("exception test");

//        return null;
    }

    @PostMapping("msg2")
    public Student getStudentMsg2(@RequestParam("name") String name) throws Exception {
        System.out.println("msg2.....");
        Thread.sleep(5000);
        System.out.println("msg2.....finish");
        throw new BizException(100, "自定义业务异常");
    }

    @GetMapping("msg2")
    public Student getStudentMsg3(@RequestParam("name") String name) {
        System.out.println(name);
        return null;
    }

    @GetMapping("get")
    public SpringBootBaseResultDTO get(@RequestParam Integer id) {
        Student s = studentService.get(id);

        return new SpringBootBaseResultDTO(200, "success", new Gson().toJson(s));
    }
}
