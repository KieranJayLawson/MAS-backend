package com.hy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.hy.mapper")
@EnableFeignClients
public class MasSSOApplication {
    public static void main(String[] args) {
        SpringApplication.run(MasSSOApplication.class, args);
    }
}
