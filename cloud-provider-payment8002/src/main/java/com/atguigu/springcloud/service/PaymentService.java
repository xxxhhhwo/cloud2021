package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

public interface PaymentService {

    //新增
    int create(Payment payment);

    //查询
    Payment getPaymentById( Integer id);

}
