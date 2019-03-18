package org.lc.springboot.entity.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class ClassTeacher {
    @Id
    private Integer id;
    @Column(name = "class_id")
    private Integer classId;
    @Column(name = "teacher_id")
    private Integer teacherId;
}
