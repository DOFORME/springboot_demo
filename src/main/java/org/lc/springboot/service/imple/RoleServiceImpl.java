package org.lc.springboot.service.imple;

import org.lc.springboot.dao.mapper.RoleMapper;
import org.lc.springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleMapper roleMapper;

    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public Set<String> selectRolesNameByUsername(String username) {
        return roleMapper.selectRolesNameByUsername(username);
    }
}
