package com.wl.springcloud.controller;

import com.wl.springcloud.entities.CommonResult;
import com.wl.springcloud.entities.Payment;
import com.wl.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yt
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value="/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("************插入结果"+result);
        if(result > 0){
            return new CommonResult(200,"插入数据库成功",payment);
        }
        return new CommonResult(500,"插入失败",null);
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("************插入结果"+result);
        if(result != null){
            return new CommonResult(200,"查询成功",result);
        }
        return new CommonResult(500,"查询失败",null);
    }
}
