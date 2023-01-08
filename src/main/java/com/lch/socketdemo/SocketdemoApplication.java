package com.lch.socketdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.lch.socketdemo.dao") //开启扫描Mapper接口的包以及子目录
@EnableTransactionManagement    //开启事务，可选项，加不加都会开启事务
public class SocketdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocketdemoApplication.class, args);
    }

}
