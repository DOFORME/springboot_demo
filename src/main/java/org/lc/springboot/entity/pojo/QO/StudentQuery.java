package org.lc.springboot.entity.pojo.QO;

import lombok.Getter;
import lombok.Setter;
import org.lc.springboot.entity.pojo.QO.group.StudentUpdateById;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class StudentQuery extends BaseQuery {
    @NotNull(groups = StudentUpdateById.class, message = "id不能为空")
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Integer classId;
    private String address;
}

