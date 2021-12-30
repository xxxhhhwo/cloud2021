package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {


    @Autowired
    PaymentService paymentService;
    @Value(("${server.port}"))
    private String port;

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

}