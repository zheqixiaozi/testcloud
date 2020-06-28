package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.SnowFlakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnowFlakeController {
    @Autowired
    private SnowFlakeService snowFlakeService;
    @GetMapping("/snowflake")
    public String getSnowFlakeId(){
        return snowFlakeService.getIDBySnowFlake();
    }
}
