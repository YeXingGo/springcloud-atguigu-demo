package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: Light
 * @ClassName PaymentDao
 * @description:
 * @create: 2020-09-17 14:10
 **/
@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPayMentById(@Param("id") Long id);
}
