package com.example.demo_xdj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.example.demo_xdj.mapper")
@SpringBootApplication
public class DemoXdjApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoXdjApplication.class, args);
    }

}
