package org.lc.springboot.manager;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ClassInfoManagerTest {
//    private ClassInfoManager classInfoManager;
//
//    @Autowired
//    public void setClassInfoManager(ClassInfoManager classInfoManager) {
//        this.classInfoManager = classInfoManager;
//    }

    @Autowired
    private ClassInfoManager classInfoManager;

    @Test
    public void getClassInfo() {
        classInfoManager.queryClassInfo(11, 11);
    }
}