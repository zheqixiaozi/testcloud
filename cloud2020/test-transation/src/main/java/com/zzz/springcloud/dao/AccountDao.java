package com.zzz.springcloud.dao;

import com.zzz.springcloud.domain.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountDao {

    Account findByUserId(Long userId);

    void update(Account account);
}
