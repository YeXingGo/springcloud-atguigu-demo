package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: Light
 * @ClassName OrderZkController
 * @description:
 * @create: 2020-09-24 18:33
 **/
@RestController
@Slf4j
public class OrderZkController {
    public static final String INVOCK_URL = "http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/cousumer/payment/zk")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOCK_URL + "/payment/zk", String.class);
        return result;
    }
}
