package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    //新增
    int create(Payment payment);

    //查询
    Payment getPaymentById(@Param("id") Integer id);

}
