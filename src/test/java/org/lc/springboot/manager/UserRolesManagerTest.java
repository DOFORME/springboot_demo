package org.lc.springboot.manager;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lc.springboot.entity.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserRolesManagerTest {
    private UserRolesManager userRolesManager;

    @Autowired
    public void setUserRolesManager(UserRolesManager userRolesManager) {
        this.userRolesManager = userRolesManager;
    }

    @Test
    public void getUserRolesByName() {
        List<Role> roles = userRolesManager.getUserRolesByName("张三");
        log.info("用户权限查询结果：{}", new Gson().toJson(roles));
    }
}