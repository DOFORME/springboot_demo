package org.lc.springboot.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.lc.springboot.entity.pojo.DO.UserDo;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    UserDo getUserByLoginNameAndFlag(@Param("loginName") String loginName, @Param("flag") int flag);
}
