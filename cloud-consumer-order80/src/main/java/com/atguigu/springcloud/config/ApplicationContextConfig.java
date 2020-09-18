package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Light
 * @ClassName ApplicationContextConfig
 * @description:
 * @create: 2020-09-17 15:50
 **/
@Configuration
public class ApplicationContextConfig {


    /**
     * @author: Light
     * @description: TODO 注入 RestTemplate 对象
     * @date: 2020/9/17 15:52
     * @return org.springframework.web.client.RestTemplate
     * @Param []
     **/
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
