package org.lc.springboot.service.imple;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.lc.springboot.entity.pojo.DTO.TeacherDTO;
import org.lc.springboot.service.SchoolService;
import org.lc.springboot.service.StudentService;
import org.lc.springboot.service.TeacherService;
import org.lc.springboot.thread.StudentServiceThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SchoolServiceImpl implements SchoolService {
    private StudentService studentService;
    private TeacherService teacherService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public void testGetTeacherAndStudent() {
        StudentServiceThread t1 = new StudentServiceThread(studentService);
        TeacherDTO[] teachers = new TeacherDTO[1];
        Thread t2 = new Thread(() -> {
            TeacherDTO dto = teacherService.getTeacherById(1);
            teachers[0] = dto;
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            log.error("发生异常：", e);
        }
        log.info("student:{}", new Gson().toJson(t1.getStudent()));
        log.info("teacher:{}", new Gson().toJson(teachers));
    }
}
