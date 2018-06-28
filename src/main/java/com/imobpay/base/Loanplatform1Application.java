package com.imobpay.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.imobpay.base.mapper.*")
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class Loanplatform1Application {
    public static void main(String[] args) {
        SpringApplication.run(Loanplatform1Application.class, args);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
