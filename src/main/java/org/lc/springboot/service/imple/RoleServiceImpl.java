package org.lc.springboot.service.imple;

import org.lc.springboot.dao.jpa.RoleJpaDao;
import org.lc.springboot.entity.pojo.Role;
import org.lc.springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleJpaDao roleJpaDao;

    @Autowired
    public void setRoleJpaDao(RoleJpaDao roleJpaDao) {
        this.roleJpaDao = roleJpaDao;
    }

    @Override
    public Role getRoleById(int id) {
        return roleJpaDao.getRoleById(id);
    }
}
