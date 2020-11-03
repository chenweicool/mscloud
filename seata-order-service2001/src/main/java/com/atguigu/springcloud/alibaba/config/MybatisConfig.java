package com.atguigu.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis的扫描的配置类
 */
@Configuration
@MapperScan({"com.atguigu.springcloud.alibaba.dao"})
public class MybatisConfig {
}
