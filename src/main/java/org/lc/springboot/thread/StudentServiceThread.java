package org.lc.springboot.thread;

import org.lc.springboot.entity.pojo.DTO.StudentDTO;
import org.lc.springboot.service.StudentService;

public class StudentServiceThread extends Thread {
    private StudentDTO student;

    public StudentDTO getStudent() {
        return student;
    }

    private StudentService studentService;
    public StudentServiceThread(StudentService service) {
        this.studentService = service;
    }

    @Override
    public void run() {
        super.run();
        student = studentService.getStudentById(1);
    }
}
