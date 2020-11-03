package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)  // 取消自动配置的数据源
@EnableDiscoveryClient
@EnableFeignClients
public class SeataMain2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataMain2001.class, args);
    }
}
