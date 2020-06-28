package com.atguigu.springcloud.controller;

import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderZKController {
    private static final String INVOME_URL = "http://cloud-provider-payment";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("consumerzk/port")
    public String getPaymentPort(){
        return restTemplate.getForObject(INVOME_URL+"/payment/zk",String.class);
    }
}
