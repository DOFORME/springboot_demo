package com.lc.springboot.demo.entity.pojo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * tips:这里entity注解引入错误会导致启动失败
 * @author lc
 */
@Data
@Entity
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10)
    @Size(max = 2)
    private String name;

    @Column(length = 10)
    @NotNull
    private String course;

}
