package org.lc.springboot.dao.jpa;

import org.lc.springboot.entity.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJpaDao extends JpaRepository<Role, Long> {
    Role getRoleById(int id);
}
