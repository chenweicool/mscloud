package com.atguigu.springcloud.alibaba.service.impl;


import com.atguigu.springcloud.alibaba.dao.AccountDao;
import com.atguigu.springcloud.alibaba.service.AccountService ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * 账户业务实现类
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);


    @Resource
    AccountDao accountDao;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {

        LOGGER.info("------->account-service中扣减账户余额开始");

        // 延时执行，feign默认是1秒进行熔断，这里设置为20秒是就会触发熔断降级，开始执行时，建议定时注释掉
        try {
           TimeUnit.SECONDS.sleep(20);
       } catch (InterruptedException e) { e.printStackTrace();
       }
        accountDao.decrease(userId,money);
        LOGGER.info("------->account-service中扣减账户余额结束");
    }
}

