package com.atguigu.springcloud.service;

import com.atguigu.springcloud.service.impl.PaymentFallbackHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE", fallback = PaymentFallbackHandler.class)
public interface IPaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentinfo_ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentinfo_timeout(@PathVariable("id") Integer id);


}
