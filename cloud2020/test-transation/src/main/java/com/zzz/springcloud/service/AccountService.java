package com.zzz.springcloud.service;

import com.zzz.springcloud.domain.Account;
import com.zzz.springcloud.domain.Total;

public interface AccountService {

    Account findByUserId(Long userId);

    void update(Account account);

    Account doMyDeal(Long userId);

    Total findTotalId(Long totalId);
}
