package org.lc.springboot.service.imple;

import org.lc.springboot.dao.mapper.PermissionMapper;
import org.lc.springboot.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {

    private PermissionMapper permissionMapper;

    @Autowired
    public void setPermissionMapper(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    public Set<String> selectPermissionsNameByRoleName(String roleName) {
        return permissionMapper.selectPermissionsNameByRoleName(roleName);
    }
}
