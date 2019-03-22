package org.lc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 启动类
 * @author lc
 * @date 2018-12-14 21:47:41
 * @version 1.0.0
 * @since 1.0.0
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.lc.springboot.dao.jpa")
@EntityScan(basePackages = "org.lc.springboot.entity.pojo.DO")
@MapperScan("org.lc.springboot.dao.mapper")
@EnableCaching
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }
}
