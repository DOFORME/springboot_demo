package org.lc.springboot.entity.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 班级
 */
@Setter
@Getter
@Entity
@Table(name = "class")
public class Clazz {
    @Id
    private Integer id;
    private Integer grade;
    private Integer no;
}
