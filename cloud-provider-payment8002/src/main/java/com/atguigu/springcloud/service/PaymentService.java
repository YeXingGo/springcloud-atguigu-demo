package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author: Light
 * @ClassName PaymentService
 * @description:
 * @create: 2020-09-17 14:25
 **/
public interface PaymentService {

    int create(Payment payment);

    Payment getPayMentById(Long id);
}
