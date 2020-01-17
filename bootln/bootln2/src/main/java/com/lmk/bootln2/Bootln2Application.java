package com.lmk.bootln2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import tk.mybatis.spring.annotation.MapperScan;

//导入tk.mybatis的MapperScan
@SpringBootApplication
@EnableAspectJAutoProxy
@MapperScan(basePackages = {"com.lmk.bootln2.mapper"})
public class Bootln2Application {

    public static void main(String[] args) {
        SpringApplication.run(Bootln2Application.class, args);
    }

}
