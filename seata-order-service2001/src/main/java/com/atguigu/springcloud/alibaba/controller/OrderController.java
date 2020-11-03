package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 顶单创建成功调用的类
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 测试地址：
     * http://localhost:2001/order/create?userId=1&productId=1&count=10&money=10
     * @param order 订单的类
     * @return 返回是否处理成功
     *
     */
    @GetMapping("/order/create")
    public CommonResult getOrder(Order order){
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
