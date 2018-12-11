package com.lc.springboot.demo.entity.pojo;

import com.lc.springboot.demo.common.BaseEntity;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("student")
@Data
public class Student extends BaseEntity {

    private String name;
    private Integer age;
    private String gender;
    private String address;

    private List<Course> courses;
}
