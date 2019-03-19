package org.lc.springboot.dao.jpa;

import org.lc.springboot.entity.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaDao extends JpaRepository<User, Long> {
    User getUserByNameAndFlag(String name, int flag);
}
