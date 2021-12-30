package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PaymentController {


    @Autowired
    RestTemplate restTemplate;

    public static final String PAHT="http://cloud-provider-payment";

    @GetMapping("/consumer/payment/zk")
   public String getPayment(){

        return restTemplate.getForObject(PAHT+"/payment/zk", String.class);
   }

}
