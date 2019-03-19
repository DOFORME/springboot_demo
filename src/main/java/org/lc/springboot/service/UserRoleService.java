package org.lc.springboot.service;

import org.lc.springboot.entity.pojo.UserRole;

import java.util.List;

public interface UserRoleService {
    List<UserRole> getUserRolesByUserId(int userId);
}
