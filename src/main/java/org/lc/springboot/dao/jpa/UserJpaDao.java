package org.lc.springboot.dao.jpa;

import org.lc.springboot.entity.pojo.DO.UserDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaDao extends JpaRepository<UserDo, Long> {
    UserDo getUserDoByLoginNameAndFlag(String loginName, int flag);
}
