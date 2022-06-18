package com.zhong.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhuyin
 */
@SpringBootApplication
@MapperScan("com.zhong.app.mapper")
public class MapperMyBatisApp {
    public static void main(String[] args) {
        SpringApplication.run(MapperMyBatisApp.class,args);
    }
}
