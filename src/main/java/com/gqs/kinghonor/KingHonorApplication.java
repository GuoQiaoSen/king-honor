package com.gqs.kinghonor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gqs.kinghonor.mapper")
public class KingHonorApplication {

    public static void main(String[] args) {
        SpringApplication.run(KingHonorApplication.class, args);
    }

}
