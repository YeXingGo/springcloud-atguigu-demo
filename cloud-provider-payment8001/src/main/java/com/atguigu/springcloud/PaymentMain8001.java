package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: Light
 * @ClassName PaymentMain8001
 * @description:
 * @create: 2020-09-17 13:31
 * @EnableDiscoveryClient 服务发现
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableAspectJAutoProxy
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class,args);
    }
}
