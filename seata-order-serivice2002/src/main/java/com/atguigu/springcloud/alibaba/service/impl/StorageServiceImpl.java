package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.StorageDao;
import com.atguigu.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao dao;

    @Override
    public void decrease(Long productId, Integer count) {
       log.info("------->storage-service 开始扣减库存了");
        dao.decrease(productId, count);
       log.info("--------> storage-service 扣减库存结束");
    }
}
