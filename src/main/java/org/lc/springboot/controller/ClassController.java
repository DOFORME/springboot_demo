package org.lc.springboot.controller;

import org.lc.springboot.common.SpringBootBaseResult;
import org.lc.springboot.entity.ClassDTO;
import org.lc.springboot.entity.query.ClassQuery;
import org.lc.springboot.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("class")
public class ClassController {
    private ClassService classService;

    @Autowired
    public void setClassService(ClassService classService) {
        this.classService = classService;
    }

    @RequestMapping(value = "query", method = RequestMethod.GET)
    public SpringBootBaseResult queryClassInfo(@RequestBody ClassQuery query) {
        ClassDTO dto = classService.queryClassInfo(query);
        return SpringBootBaseResult.ok(dto);
    }
}
