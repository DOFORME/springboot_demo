package com.lc.demo.springboot.controller;

import com.google.gson.Gson;
import com.lc.demo.springboot.entity.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Slf4j
public class StudentControllerTest {

    private WebApplicationContext webApplicationContext;

    @Autowired
    public void setWebApplicationContext(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void save() throws Exception {
        Student student = new Student();
        student.setName("test");
        String requestBody = new Gson().toJson(student);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/student/save").contentType(MediaType.APPLICATION_JSON).content(requestBody))
                .andDo(print()).andReturn();
        log.warn(result.getResponse().getContentAsString());
    }
}