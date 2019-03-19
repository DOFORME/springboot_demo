package org.lc.springboot.service.imple;

import org.lc.springboot.dao.jpa.UserJpaDao;
import org.lc.springboot.entity.pojo.User;
import org.lc.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserJpaDao userJpaDao;

    @Autowired
    public void setUserJpaDao(UserJpaDao userJpaDao) {
        this.userJpaDao = userJpaDao;
    }

    @Override
    public User getUserByName(String name) {
        return userJpaDao.getUserByNameAndFlag(name, 1);
    }
}
