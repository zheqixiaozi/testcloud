package com.zzz.springcloud.controller;

import com.zzz.springcloud.domain.Account;
import com.zzz.springcloud.domain.Total;
import com.zzz.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/account/deal/{userId}")
    public Account testTrans(@PathVariable("userId")Long userId){
        log.info("线程名："+Thread.currentThread().getName()+",userId:"+userId);
        return accountService.doMyDeal(userId);
    }

    @GetMapping(value = "/account/findByUserId/{userId}")
    public Account findByUserId(@PathVariable("userId")Long userId){
        log.info("线程名："+Thread.currentThread().getName()+",userId:"+userId);
        return accountService.findByUserId(userId);
    }

    @GetMapping(value = "/account/update")
    public void update(Account account){
        accountService.update(account);
    }


}
