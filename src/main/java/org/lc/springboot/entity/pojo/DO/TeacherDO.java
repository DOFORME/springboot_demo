package org.lc.springboot.entity.pojo.DO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import javax.persistence.Id;

@Getter
@Setter
@ToString
@Alias("teacher")
public class TeacherDO extends BaseDO {
    @Id
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
}
