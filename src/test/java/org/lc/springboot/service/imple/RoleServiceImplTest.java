package org.lc.springboot.service.imple;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lc.springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RoleServiceImplTest {
    @Autowired
    private RoleService roleService;

    @Test
    public void selectRolesNameByUsername() {
        Set<String> roleNames = roleService.selectRolesNameByUsername("lc");
        log.error(new Gson().toJson(roleNames));
    }
}