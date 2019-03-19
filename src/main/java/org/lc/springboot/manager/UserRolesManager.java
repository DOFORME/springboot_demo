package org.lc.springboot.manager;

import org.lc.springboot.dao.jpa.RoleJpaDao;
import org.lc.springboot.dao.jpa.UserJpaDao;
import org.lc.springboot.dao.jpa.UserRoleJpaDao;
import org.lc.springboot.entity.pojo.Role;
import org.lc.springboot.entity.pojo.User;
import org.lc.springboot.entity.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRolesManager {
    private UserJpaDao userJpaDao;
    private RoleJpaDao roleJpaDao;
    private UserRoleJpaDao userRoleJpaDao;

    @Autowired
    public void setUserJpaDao(UserJpaDao userJpaDao) {
        this.userJpaDao = userJpaDao;
    }

    @Autowired
    public void setRoleJpaDao(RoleJpaDao roleJpaDao) {
        this.roleJpaDao = roleJpaDao;
    }

    @Autowired
    public void setUserRoleJpaDao(UserRoleJpaDao userRoleJpaDao) {
        this.userRoleJpaDao = userRoleJpaDao;
    }

    public List<Role> getUserRolesByName(String name) {
        User user = userJpaDao.getUserByNameAndFlag(name, 1);
        List<UserRole> userRoles = userRoleJpaDao.getUserRolesByUserId(user.getId());
        List<Role> roles = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            Role role = roleJpaDao.getRoleById(userRole.getRoleId());
            roles.add(role);
        }
        return roles;
    }
}
