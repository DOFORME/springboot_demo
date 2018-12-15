package com.lc.springboot.demo.entity.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


/**
 * tips:这里entity注解引入错误会导致启动失败
 * @author lc
 */
@Data
@Entity
//@Table(name = "teacher")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @Column(length = 10)
    private String name;

//    @Column(length = 10)
//    private String course;

}
