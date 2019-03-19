package org.lc.springboot.service;

import org.lc.springboot.entity.ClassDTO;
import org.lc.springboot.entity.query.ClassQuery;

public interface ClassService {

    ClassDTO queryClassInfo(ClassQuery query);
}
