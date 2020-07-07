package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@EnableScheduling  //定时器 注解
@EnableCaching //缓存注解
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //设置上传文件的大小
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //指定文件代销
        factory.setMaxFileSize("100MB");
        /// 设定上传文件大小
        factory.setMaxRequestSize("1000MB");
        return factory.createMultipartConfig();

    }
}
