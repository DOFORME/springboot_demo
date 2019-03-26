package org.lc.springboot.entity.pojo.QO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
class BaseQuery {
    private Integer id;
    private String createBy;
    private String updateBy;
    private LocalDate createAt;
    private LocalDate updateAt;
    private String remark;
    private Integer flag;
}
