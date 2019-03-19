package org.lc.springboot.system.security;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.lc.springboot.entity.pojo.Role;
import org.lc.springboot.entity.pojo.User;
import org.lc.springboot.manager.UserRolesManager;
import org.lc.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义Realm（需实现的核心部分）
 * https://github.com/YorkeCao/shiro-spring-boot-sample
 * https://segmentfault.com/a/1190000008847948
 */
public class CustomRealm extends AuthorizingRealm {
    private UserRolesManager userRolesManager;
    private UserService userService;

    @Autowired
    public void setUserRolesManager(UserRolesManager userRolesManager) {
        this.userRolesManager = userRolesManager;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) super.getAvailablePrincipal(principalCollection);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<Role> roles = userRolesManager.getUserRolesByName(username);
        Set<String> rs = new HashSet<>();
        for (Role r : roles) {
            rs.add(r.getName());
        }
        info.setRoles(rs);
        return null;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User user = userService.getUserByName(username);
        String password = user.getPassword();
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
