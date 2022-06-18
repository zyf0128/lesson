package com.zhong.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.print.Doc;

/**
 * @author zhuyin
 */
@Configuration
@EnableSwagger2
@PropertySource("application.properties")
public class SwaggerConfig {

    @Value("${server.port}")
    private int port;

    public ApiInfo getSwaggerInfo(){
        ApiInfo build = new ApiInfoBuilder()
                .title("Lesson视频项目接口文档")
                .description("用于线上卖课的网站..")
                .version("1.0.1")
                .contact(new Contact("zhuyin", "http://localhost:8081", "zhuyin_dsw@163.com"))
                .build();
        return build;
    }

    /**
     * 用于分组
     * @return
     */
    @Bean
    public Docket docketA(){
        if(this.port == 5279){
            return new Docket(DocumentationType.SWAGGER_2)
                    .groupName("docket-a")
                    .apiInfo(getSwaggerInfo())
                    .select().apis(RequestHandlerSelectors.basePackage("com.zhong.app.controller"))
                    .paths(PathSelectors.ant("/api/v3/**"))
                    .build();
        }
       return new Docket(DocumentationType.SWAGGER_2);
    }










}
