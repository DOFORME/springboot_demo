package org.lc.springboot.service;

import java.util.Set;

public interface PermissionService {

    Set<String> selectPermissionsNameByRoleName(String roleName);
}
