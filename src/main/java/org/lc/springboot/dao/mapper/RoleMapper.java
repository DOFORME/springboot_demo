package org.lc.springboot.dao.mapper;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public interface RoleMapper {

    Set<String> selectRolesNameByUsername(String username);
}
