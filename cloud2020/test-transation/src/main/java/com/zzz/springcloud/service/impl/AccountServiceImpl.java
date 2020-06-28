package com.zzz.springcloud.service.impl;

import com.zzz.springcloud.dao.AccountDao;
import com.zzz.springcloud.dao.TotalDao;
import com.zzz.springcloud.domain.Account;
import com.zzz.springcloud.domain.Total;
import com.zzz.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;
    @Resource
    private TotalDao totalDao;

    @Override
    public Account findByUserId(Long userId) {
        return accountDao.findByUserId(userId);
    }

    @Override
    public Total findTotalId(Long totalId) {
        return totalDao.findByUserId(totalId);
    }



    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Transactional
    public Account doMyDeal(Long userId){
        Account account = findByUserId(userId);
        Total total = totalDao.findByUserId(account.getTotalId());

        log.info("线程名："+Thread.currentThread().getName()+",查询的account:"+account);
        log.info("线程名："+Thread.currentThread().getName()+",查询的total:"+total);

        account.setTotal(account.getTotal().subtract(new BigDecimal(10)));
        total.setTotal(total.getTotal().subtract(new BigDecimal(10)));
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (Thread.currentThread().getName().contains("5")){
            throw new RuntimeException("我自己报错了");
        }
        update(account);
        totalDao.update(total);
        log.info("线程名："+Thread.currentThread().getName()+",更新后的account:"+account);
        log.info("线程名："+Thread.currentThread().getName()+",更新后的total:"+total);
        return account;
    }
}
