package org.lc.springboot.manager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
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
        classInfoManager.getClassInfo(11, 11);
    }
}