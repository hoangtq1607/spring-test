package com.example.springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass=true)
@SpringBootApplication
public class SpringTestApplication {
    // comment
    public static void main(String[] args) {
        SpringApplication.run(SpringTestApplication.class, args);
    }
}
