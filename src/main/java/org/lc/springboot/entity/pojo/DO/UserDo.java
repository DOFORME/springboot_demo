package org.lc.springboot.entity.pojo.DO;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Alias("user")
@Entity
@Table(name = "sys_user")
public class UserDo extends BaseDO {
    @Id
    private Integer id;
    @Column(name = "login_name")
    private String loginName;
    @Column(name = "nick_name")
    private String nickName;
    private String password;
    private Integer flag;
}
