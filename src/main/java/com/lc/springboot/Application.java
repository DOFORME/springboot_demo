package com.lc.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 启动类
 * @author lc
 * @date 2018-12-14 21:47:41
 * @version 1.0.0
 * @since 1.0.0
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.lc.springboot.demo.dao.jpa")
@EntityScan(basePackages = "com.lc.springboot.demo.entity.pojo")
@MapperScan("com.lc.springboot.demo.dao.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
