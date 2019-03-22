package org.lc.springboot.service;

import java.util.Set;

public interface RoleService {

    Set<String> selectRolesNameByUsername(String username);
}
