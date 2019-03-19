package org.lc.springboot.service;

import org.lc.springboot.entity.pojo.User;

public interface UserService {

    User getUserByName(String name);
}
