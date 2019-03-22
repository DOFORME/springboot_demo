package org.lc.springboot.entity.pojo.DO;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "aust_student")
@Alias("student")
public class StudentDO extends BaseDO {
    @Id
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    @Column(name = "class_id")
    private Integer classId;
    private String address;
}
