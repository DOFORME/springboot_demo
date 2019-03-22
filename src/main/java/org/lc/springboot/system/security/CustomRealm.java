package org.lc.springboot.system.security;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.lc.springboot.dao.mapper.PermissionMapper;
import org.lc.springboot.dao.mapper.RoleMapper;
import org.lc.springboot.dao.mapper.UserMapper;
import org.lc.springboot.entity.pojo.DO.UserDo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * 自定义Realm（需实现的核心部分）
 * https://github.com/YorkeCao/shiro-spring-boot-sample
 * https://segmentfault.com/a/1190000008847948
 */
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;


    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        UserDo user = userMapper.getUserByLoginNameAndFlag(username, 1);
        if (user == null) {
            return null;
        }
        String password = user.getPassword();
        return new SimpleAuthenticationInfo(username, password, getName());
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) super.getAvailablePrincipal(principalCollection);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = roleMapper.selectRolesNameByUsername(username);
        authorizationInfo.setRoles(roles);
        roles.forEach(roleName -> {
            Set<String> permissions = permissionMapper.selectPermissionsNameByRoleName(roleName);
            authorizationInfo.addStringPermissions(permissions);
        });
        return authorizationInfo;
    }
}
