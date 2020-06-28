package com.zzz.springcloud.dao;

import com.zzz.springcloud.domain.Total;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TotalDao {

    Total findByUserId(Long totalId);

    void update(Total total);
}
