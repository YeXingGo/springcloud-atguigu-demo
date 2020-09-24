package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: Light
 * @ClassName PaymentController
 * @description:
 * @create: 2020-09-17 14:28
 **/
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    /**
     * @author: Light
     * @description: TODO 创建Payment记录
     * @date: 2020/9/17 14:37
     * @return com.atguigu.springcloud.entities.CommonResult
     * @Param [payment]
     **/
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);
        System.out.println("走");
        if (result > 0 ) {
            return new CommonResult(200,"插入数据成功 serverPort:"+serverPort,result);
        }
        else {
            return new CommonResult(444,"插入数据库失败");
        }
    }

    /**
     * @author: Light
     * @description: TODO 根据ID 获取 Payment
     * @date: 2020/9/17 14:35
     * @return com.atguigu.springcloud.entities.CommonResult
     * @Param [payment]
     **/
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPayMentById(id);
        log.info("*****获取结果：" + payment+" 中国");
        System.out.println("123");
        if (payment != null ) {
            return new CommonResult(200,"查询成功 serverPort: "+serverPort,payment);
        }
        else {
            return new CommonResult(444,"没有对应的记录，查询ID: "+id);
        }
    }
}
