package com.lc.springboot.demo.controller;

import com.google.gson.Gson;
import com.lc.springboot.demo.dao.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/index", method = RequestMethod.GET)
public class IndexController {

    @Autowired
    private StudentMapper studentMapper;

//    @RequestMapping(value = {"/index/{id}"}, method = RequestMethod.GET)
    @GetMapping("/index")
    public String toIndex(@RequestParam("id") Integer id) {
        Gson json = new Gson();
        return "hello spring boot";
    }
}
