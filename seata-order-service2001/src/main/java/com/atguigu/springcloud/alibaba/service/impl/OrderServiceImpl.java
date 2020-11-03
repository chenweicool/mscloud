package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.OrderDao;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.AccountService;
import com.atguigu.springcloud.alibaba.service.OrderService;
import com.atguigu.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 具体的订单的实现类
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    /**
     * 具体的处理逻辑的实现
      下订单-->扣库存-->减账户（余额）
     * @param order 具体的订单的类的实现
     */
    @Override
    @GlobalTransactional  // 实现全局的事物控制
    public void create(Order order) {
        // 创建订单
        log.info("开始创建订单");
        orderDao.create(order);
        log.info("订单创建成功");

        // 扣减库存
        log.info("准备扣减库存");
        storageService.decrease(order.getUserId(),order.getCount());
        log.info("扣减库存成功");

        // 扣减余额
        log.info("准备扣减余额");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("扣款成功");

        // 修改订单的状态
        log.info("准备修改订单的状态");
        orderDao.update(order.getUserId(), 0);
        log.info("订单的状态修改完成");

        log.info("订单已完结");
    }
}
