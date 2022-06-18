package com.zhong.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zhuyin
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
@MapperScan("com.zhong.app.mapper")
public class ServiceSpringApp {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSpringApp.class,args);
    }
}
