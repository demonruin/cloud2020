package com.king.springcloud.service.impl;

import com.king.springcloud.dao.StorageDao;
import com.king.springcloud.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * created by king on 2020/6/4 10:55 下午
 */
@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);
    @Resource
    private StorageDao storageDao;     // 扣减库存

    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        LOGGER.info("------->storage-service中扣减库存结束");
    }

}
