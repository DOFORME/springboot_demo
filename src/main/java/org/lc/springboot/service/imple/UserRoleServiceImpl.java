package org.lc.springboot.service.imple;

import org.lc.springboot.dao.jpa.UserRoleJpaDao;
import org.lc.springboot.entity.pojo.UserRole;
import org.lc.springboot.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private UserRoleJpaDao userRoleJpaDao;

    @Autowired
    public void setUserRoleJpaDao(UserRoleJpaDao userRoleJpaDao) {
        this.userRoleJpaDao = userRoleJpaDao;
    }

    @Override
    public List<UserRole> getUserRolesByUserId(int userId) {
        return userRoleJpaDao.getUserRolesByUserId(userId);
    }
}
