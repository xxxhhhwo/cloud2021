package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/payment/zk")
    public String payment(){

        return "当前微服务：cloud-provider-payment 端口号"+port+"---"+ UUID.randomUUID().toString();
    }

}
