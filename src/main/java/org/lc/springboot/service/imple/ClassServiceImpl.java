package org.lc.springboot.service.imple;

import org.lc.springboot.entity.ClassDTO;
import org.lc.springboot.entity.query.ClassQuery;
import org.lc.springboot.manager.ClassInfoManager;
import org.lc.springboot.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService {
    private ClassInfoManager classInfoManager;

    @Autowired
    public void setClassInfoManager(ClassInfoManager classInfoManager) {
        this.classInfoManager = classInfoManager;
    }

    @Override
    public ClassDTO queryClassInfo(ClassQuery query) {
        return classInfoManager.queryClassInfo(query.getGrade(), query.getNo());
    }
}
