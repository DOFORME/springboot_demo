package org.lc.springboot.entity;

import lombok.Getter;
import lombok.Setter;
import org.lc.springboot.entity.pojo.Clazz;
import org.lc.springboot.entity.pojo.Student;
import org.lc.springboot.entity.pojo.Teacher;

import java.util.List;

@Getter
@Setter
public class ClassDTO {
    private Clazz clazz;
    private List<Teacher> teachers;
    private List<Student> students;
}
