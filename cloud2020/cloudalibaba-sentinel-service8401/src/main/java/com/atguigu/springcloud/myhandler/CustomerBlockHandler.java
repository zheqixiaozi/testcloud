package com.atguigu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

public class CustomerBlockHandler {


    public static CommonResult handleException1(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....1,  CustomerBlockHandler");

    }

    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(4444, "自定义限流处理信息....2,  CustomerBlockHandler");

    }
}
