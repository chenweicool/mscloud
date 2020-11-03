package com.atguigu.springcloud.alibaba.service;

/**
 * 扣减库存的实现
 */
public interface StorageService {
    // 扣减库存
    void decrease(Long productId, Integer count);
}
