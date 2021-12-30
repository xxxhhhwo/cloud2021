package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {


    @Autowired
    PaymentService paymentService;
    @Value(("${server.port}"))
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    //增加
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        log.info("插入数据返回：{}", i);
        if (i > 0) {
            return new CommonResult(200, "插入数据成功,port:"+port, i);
        } else {
            return new CommonResult(444, "数据不存在，添加失败", null);
        }
    }

    //增加
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Integer id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询数据返回：{}", payment);
        if (payment!=null) {
            return new CommonResult(200, "查询数据成功,port:"+port, payment);
        } else {
            return new CommonResult(444, "数据不存在，查询失败", null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
                for (String str:services){
                    log.info("element*******"+str);
                }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("主机名：{}，ip:{}", instance.getHost(),instance.getUri());
        }
        return discoveryClient;


    }

}