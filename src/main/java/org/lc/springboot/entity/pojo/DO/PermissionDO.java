package org.lc.springboot.entity.pojo.DO;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias("permission")
public class PermissionDO extends BaseDO {
    private String name;
    private String description;
}
