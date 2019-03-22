package org.lc.springboot.manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserRolesManager {
//    private UserJpaDao userJpaDao;
//    private RoleJpaDao roleJpaDao;
//    private UserRoleJpaDao userRoleJpaDao;
//
//    @Autowired
//    public void setUserJpaDao(UserJpaDao userJpaDao) {
//        this.userJpaDao = userJpaDao;
//    }
//
//    @Autowired
//    public void setRoleJpaDao(RoleJpaDao roleJpaDao) {
//        this.roleJpaDao = roleJpaDao;
//    }
//
//    @Autowired
//    public void setUserRoleJpaDao(UserRoleJpaDao userRoleJpaDao) {
//        this.userRoleJpaDao = userRoleJpaDao;
//    }
//
//    public Set<Role> getUserRolesByName(String name) {
//        long start = System.currentTimeMillis();
//        User user = userJpaDao.getUserByNameAndFlag(name, 1);
//        List<UserRole> userRoles = userRoleJpaDao.getUserRolesByUserId(user.getId());
//        Set<Role> roles = new HashSet<>();
//        for (UserRole userRole : userRoles) {
//            Role role = roleJpaDao.getRoleById(userRole.getRoleId());
//            roles.add(role);
//        }
//        long cost = System.currentTimeMillis() - start;
//        log.info("用户：｛｝，查询权限，耗时：｛｝ms", name, cost);
//        return roles;
//    }
}
