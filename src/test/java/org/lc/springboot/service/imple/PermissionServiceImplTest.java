package org.lc.springboot.service.imple;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lc.springboot.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PermissionServiceImplTest {
    @Autowired
    private PermissionService permissionService;

    @Test
    public void selectPermissionsNameByRoleName() {
        Set<String> names = permissionService.selectPermissionsNameByRoleName("admin");
        log.error(new Gson().toJson(names));
    }
}