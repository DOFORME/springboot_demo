package org.lc.springboot.dao.jpa;

import org.lc.springboot.entity.pojo.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleJpaDao extends JpaRepository<UserRole, Long> {
    List<UserRole> getUserRolesByUserId(int userId);
}
