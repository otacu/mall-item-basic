package com.egoist.mall.item.basic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.egoist.mall.item.basic.dao")//将项目中对应的mapper类的路径加进来就可以了
@SpringBootApplication
public class MallItemBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallItemBasicApplication.class, args);
    }

}
