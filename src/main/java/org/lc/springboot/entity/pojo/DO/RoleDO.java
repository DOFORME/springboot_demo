package org.lc.springboot.entity.pojo.DO;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias("role")
public class RoleDO extends BaseDO {
    private String name;
}
