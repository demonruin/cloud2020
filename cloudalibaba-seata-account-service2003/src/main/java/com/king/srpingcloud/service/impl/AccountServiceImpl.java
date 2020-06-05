package com.king.srpingcloud.service.impl;

import com.king.srpingcloud.dao.AccountDao;
import com.king.srpingcloud.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * created by king on 2020/6/4 11:16 下午
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
//        try {
////            TimeUnit.SECONDS.sleep(20);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
        int i = 1/0;
        accountDao.decrease(userId, money);
        LOGGER.info("------->account-service中扣减账户余额结束");
    }
}
