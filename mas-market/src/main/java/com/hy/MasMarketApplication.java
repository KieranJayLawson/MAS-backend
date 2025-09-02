package com.hy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
@SpringBootApplication
@EnableScheduling
@MapperScan("com.hy.mapper")
public class MasMarketApplication {
    public static void main(String[] args) {
        SpringApplication.run(MasMarketApplication.class,args);
    }
}