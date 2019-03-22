package org.lc.springboot.entity.pojo.DO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
class BaseDO {
    @Id
    private Integer id;
    private String createBy;
    private String updateBy;
    private LocalDate createAt;
    private LocalDate updateAt;
    private String remark;
    private Integer flag;
}
